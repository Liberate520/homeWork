package family_tree.model.writer;

import family_tree.model.family_tree.FamilyTree;

import java.io.*;

public class FileHandler implements WritableLoadable {
    @Override
    public void writToFile(FamilyTree familyTree, File file) throws IOException, ClassNotFoundException{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }

    @Override
    public FamilyTree readFromFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        FamilyTree familyTree1 = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return familyTree1;
    }
}
