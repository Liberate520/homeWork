package Model.tree;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class FileWorker<T extends Creature> implements Writable{
    @Override
    public void writeTreeToFile(FamilyTree inputTree) throws IOException {
        String pathname = inputTree.getName().toLowerCase() + ".txt";
        try {
            File tree = new File(pathname);
            tree.createNewFile();
        } catch (IOException e) {
            System.out.println("Что-то пошло не так. Не удалось обратиться к файлу.");
            e.printStackTrace();
        }

        try {
            Path path = Paths.get(pathname);
            String str = LocalDateTime.now() + "\n" + inputTree + "\n\n";
            Files.write(path, str.getBytes(), StandardOpenOption.APPEND);
            System.out.println("\nДрево '" + inputTree.getName() + "' успешно сохранено.");
        } catch (IOException e) {
            System.out.println("Что-то пошло не так. Запись не произведена.");
            e.printStackTrace();
        }
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
            System.out.println("\nЧтение из файла прошло успешно");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputTree;
    }

    @Override
    public void writeCreatureToFile(Creature creature) throws IOException {
        String pathname = creature.getFullName().toLowerCase() + ".txt";
        try {
            File tree = new File(pathname);
            tree.createNewFile();
        } catch (IOException e) {
            System.out.println("Что-то пошло не так. Не удалось обратиться к файлу.");
            e.printStackTrace();
        }

        try {
            Path path = Paths.get(pathname);
            String str = LocalDateTime.now() + "\n" + creature + "\n\n";
            Files.write(path, str.getBytes(), StandardOpenOption.APPEND);
            System.out.println("\n" + creature.getFullName() + " успешно сохранен.");
        } catch (IOException e) {
            System.out.println("Что-то пошло не так. Запись не произведена.");
            e.printStackTrace();
        }
    }
}
