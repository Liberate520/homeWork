
import java.io.*;

public class BinaryDataStorage implements DataStorage {
    @Override
    public void saveData(GenealogicalTree tree, String fileName) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(tree);
            objectOutputStream.close();
            fileOutputStream.close();

            System.out.println("Data saved successfully to the file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the data to the file.");
            e.printStackTrace();
        }
    }

    @Override
    public GenealogicalTree loadData(String fileName) {
        GenealogicalTree tree = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            tree = (GenealogicalTree) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

            System.out.println("Data loaded successfully from the file: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred while loading the data from the file.");
            e.printStackTrace();
        }

        return tree;
    }
}


