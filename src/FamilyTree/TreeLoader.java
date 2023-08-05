package FamilyTree;

import java.io.*;

public class TreeLoader implements Writable{

    @Override
    public void Save(String filename, FamilyTree saved) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(String.format("%s.out",filename)));
        objectOutputStream.writeObject(saved);
        objectOutputStream.close();

    }

    @Override
    public FamilyTree Load(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(String.format("%s.out",filename)));
        FamilyTree restoredFile = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return restoredFile;
    }
}
