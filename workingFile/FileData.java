package workingFile;

import tree.Node;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class FileData extends ListDataImpl{

    private Path file;
    public ArrayList<String> contents = new ArrayList<>();
    private  String template;


    public FileData(String filePath, String template) {

        this.template = template;
        load(filePath);

    }


    public String load(String filePath) {
        try {
            this.file = Paths.get(filePath);
            this.contents = (ArrayList<String>) Files.readAllLines(file);
        } catch (IOException e) {
            this.contents.add("Файл отсутствует или имеет некорректный формат");
        }
        return filePath;
    }




    public void add(Node n) {
        String data = n.toFileString();
        this.contents.add(data);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile()))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(data);
    }


    public void change(Node n, Node m) {
        int index = getInd(n);
        super.change(n, m);
        String data = m.toFileString();
        contents.set(index, data);
        try {
            Files.write(file, contents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void remove(Node n) {
        int index = getInd(n);
        contents.remove(index);
        try {
            Files.write(file, contents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}





