package file;

import tree.FamilyTree;

import java.io.*;

public class FileUtil implements InterfaceFile {
    public void saveToFile(FamilyTree humans, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(humans);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FamilyTree readFromFile(String fileName) {
        FamilyTree humans = new FamilyTree();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            humans = (FamilyTree) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return humans;
    }


}
