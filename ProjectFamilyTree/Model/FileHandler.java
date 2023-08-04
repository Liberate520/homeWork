package homeWork.ProjectFamilyTree.Model;

import java.io.Serializable;
import java.io.*;

public class FileHandler implements Writable {
    @Override
    public void Save(Serializable object) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("family.out"));
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }

    @Override
    public Object Load() throws IOException, ClassNotFoundException{
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("family.out"));
        Family_tree familyTree = (Family_tree) objectInputStream.readObject();
        objectInputStream.close();
        return familyTree;
    }
}
