package Model.tree;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class FileWorker<T extends Creature> implements Writable{
    @Override
    public boolean writeTreeToFile(FamilyTree inputTree) throws IOException {
        boolean userMessage;
        String pathname = inputTree.getName().toLowerCase() + ".txt";
        try {
            File tree = new File(pathname);
            tree.createNewFile();
        } catch (IOException e) {
            e.getLocalizedMessage();
        }

        try {
            Path path = Paths.get(pathname);
            String str = LocalDateTime.now() + "\n" + inputTree + "\n\n";
            Files.write(path, str.getBytes(), StandardOpenOption.APPEND);
            userMessage = true;
        } catch (IOException e) {
            userMessage = false;
        }
        return userMessage;
    }

    @Override
    public FamilyTree<T> readTreeFromFile(FamilyTree inputTree) {
        String pathname = "read.txt";

        try {
            File file = new File(pathname);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                if (inputTree.getTreeElements().get(0) instanceof Cat) {
                    Cat element = new Cat(line.split(",")[0], (Gender.valueOf(line.split(",")[2])),
                            Integer.parseInt(line.split(",")[1]));
                    inputTree.addElement(element);
                    line = reader.readLine();
                } else {
                    Human element = new Human(line.split(",")[0], (Gender.valueOf(line.split(",")[2])),
                            Integer.parseInt(line.split(",")[1]));
                    inputTree.addElement(element);
                    line = reader.readLine();
                }
            }
//            System.out.println("\nЧтение из файла прошло успешно");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputTree;
    }

    @Override
    public boolean writeCreatureToFile(Creature creature) throws IOException {
        boolean userMessage;
        String pathname = creature.getFullName().toLowerCase() + ".txt";
        try {
            File tree = new File(pathname);
            tree.createNewFile();
        } catch (IOException e) {
            e.getLocalizedMessage();
        }

        try {
            Path path = Paths.get(pathname);
            String str = LocalDateTime.now() + "\n" + creature + "\n\n";
            Files.write(path, str.getBytes(), StandardOpenOption.APPEND);
            userMessage = true;
        } catch (IOException e) {
            userMessage = false;
        }
        return userMessage;
    }
}
