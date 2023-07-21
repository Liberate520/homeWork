package homeWork.tree2.backend.fileHandler;
import homeWork.tree2.backend.familyTree.FamilyTree;

import java.io.*;

public class FileHandler implements ToSaveAndLoadInterface {

    @Override
    public void save(FamilyTree familyTree) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("family.out"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }

    @Override
    public FamilyTree load() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("family.out"));
        FamilyTree familyTree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return familyTree;
    }
}
