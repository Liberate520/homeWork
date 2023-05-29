package model.filesaver;
import model.familytree.FamilyTree;

import java.io.*;

public class FileReaderWriter implements Saveable {
    @Override
    public boolean save(Serializable serializable, String path) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FamilyTree read(String path) {
        FamilyTree familyTree = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
            familyTree = (FamilyTree) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return familyTree;
    }
}
