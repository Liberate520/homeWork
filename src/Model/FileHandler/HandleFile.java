package Model.FileHandler;

import Model.FamilyTree.FamilyTree.FamilyTree;

import java.io.*;
import java.util.logging.FileHandler;

public class HandleFile implements Writable {
    protected FileHandler fileHandler;

    public HandleFile(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    public HandleFile() throws IOException {
        this(new FileHandler());
    }

    @Override
    public void writeToFile(Serializable familyTree, String path) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(path));
            objectOutputStream.writeObject(familyTree);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FamilyTree readFromFile(String path) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(path));
            FamilyTree familyTree = (FamilyTree) objectInputStream.readObject();
            objectInputStream.close();
            return familyTree;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
