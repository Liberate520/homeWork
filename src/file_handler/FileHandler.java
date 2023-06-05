package file_handler;

import family_tree.FamilyTree;
import file_handler.WorkingFileData;

import java.io.*;

public class FileHandler implements WorkingFileData {
    @Override
    public void save(FamilyTree familyTree) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("familyTree.out");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();

    }

    @Override
    public FamilyTree load() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("familyTree.out");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        FamilyTree familyTree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return familyTree;
    }
}
