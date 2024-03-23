package writer;

import java.io.*;

import tree.FamilyTree;
import tree.Person;

public class FileHandler implements Writable {
    private String filePath = "serial.txt";

    public FileHandler() {
    }

    @Override
    public boolean save(FamilyTree tree) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("person.out"));
            objectOutputStream.writeObject(tree);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public FamilyTree load() throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("person.out"))) {

            // Считываем объект FamilyTree из файла
            FamilyTree loadedTree = (FamilyTree) objectInputStream.readObject();

            return loadedTree;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
