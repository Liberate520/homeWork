package file_handler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import human.Human;

public class FileHandler {
    private static final String FILE_PATH = "homeWork_family_tree/output/human_data.ser";

    public static void saveToFile(List<Human> humanList) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            outputStream.writeObject(humanList);
            System.out.println("Data saved to file: " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Human> loadFromFile() {
        List<Human> humanList = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            humanList = (List<Human>) inputStream.readObject();
            System.out.println("Data loaded from file: " + FILE_PATH);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return humanList;
    }
}
