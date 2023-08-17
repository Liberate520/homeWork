package homeWork.ProjectFamilyTree.Model;

import java.io.Serializable;
import java.io.*;
public class FileHandler implements Save, Load {
    @Override
    public void Save(Serializable object) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("homeWork/ProjectFamilyTree/family.out"));
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }

    @Override
    public Object Load() throws IOException, ClassNotFoundException{
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("homeWork/ProjectFamilyTree/family.out"));
        Family_tree familyTree = (Family_tree) objectInputStream.readObject();
        objectInputStream.close();
        return familyTree;
    }
}
