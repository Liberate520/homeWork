package model.file;

import model.tree.FamilyTree;

import java.io.*;

public class FileUtil implements InterfaceFile {
    public boolean saveToFile(FamilyTree humans, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(humans);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
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
