package write;

import entity.*;
import familytree.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileHandler implements Writable {

    private String fileName = "";
    private String fileExtension = ".txt";
    private int fileType = 0;
    private String fileTypeDescription = "text file";

    @Override
    public void defineFileName(String fileName) {
        this.fileName = fileName + fileExtension;
    }

    @Override
    public String fileName() {
        return fileName;
    }

    @Override
    public int fileType() { return fileType;}

    @Override
    public String fileTypeDescription() { return fileTypeDescription; }

    @Override
    public void save(Serializable serializable) {

        FamilyTree saveTree = (FamilyTree)serializable;
        String content = toText(saveTree);

        try (FileWriter fw = new FileWriter(fileName, false)) {
            fw.write(content);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public FamilyTree load() {
        String result = "";

        File file = new File(fileName);
        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                result += line + "\n";
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return fromText(result);
    }

    private String findMatch(String extractStr, String field) {

        Pattern pattern = Pattern.compile(field + ": (.*?);");
        Matcher matcher = pattern.matcher(extractStr);

        String findStr = "";
        if (matcher.find() && matcher.group(1) != null)
            findStr = matcher.group(1);
        return findStr;
    }

    public String toText(FamilyTree familyTree) {
        String str = familyTree.toString();
        int itemIndex = 0;
        String txt = "";

        while (str.indexOf("\n", itemIndex) > 0) {

            String line = str.substring(itemIndex, str.indexOf("\n", itemIndex)) + ';';

            if (itemIndex == 0) {
                txt = txt + line + "\n";
            }
            else {
                txt = txt + "id: " + findMatch(line, "id") + ";";
                txt = txt + " type: " + findMatch(line, "type") + ";";
                txt = txt + " name: " + findMatch(line, "name") + ";";
                txt = txt + " gender: " + findMatch(line, "gender") + ";";
                if (line.contains("father"))
                    txt = txt + " father: " + findMatch(line, "father") + ";";
                if (line.contains("mother"))
                    txt = txt + " mother: " + findMatch(line, "mother") + ";";
                txt = txt + "\n";
            }
            itemIndex = str.indexOf("\n", itemIndex) + 1;
        }
        return txt;
    }


    public FamilyTree fromText(String str) {
        int itemIndex = 0;
        String id = "", type = "", name = "", gender = "", fathername = "", mothername = "";
        FamilyTree loadTree = new FamilyTree();
        Mammal member;

        while (str.indexOf("\n", itemIndex) > 0) {

            String line = str.substring(itemIndex, str.indexOf("\n", itemIndex)) + ';';

            if (itemIndex == 0) {
                loadTree.setName(line);
            }
            else {
                id = findMatch(line, "id");
                type = findMatch(line, "type");
                name = findMatch(line, "name");
                gender = findMatch(line, "gender");
                fathername = findMatch(line, "father");
                mothername = findMatch(line, "mother");
                if (type.equals("human"))
                    member = new Human(Integer.parseInt(id), name, gender, loadTree.getMemberByName(fathername), loadTree.getMemberByName(mothername));
                else
                    member = new Cat(Integer.parseInt(id), name, gender, loadTree.getMemberByName(fathername), loadTree.getMemberByName(mothername));
                loadTree.addMember(member);
            }

            itemIndex = str.indexOf("\n", itemIndex) + 1;
        }
        return loadTree;
    }
}