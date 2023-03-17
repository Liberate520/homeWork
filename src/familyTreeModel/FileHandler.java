package familyTreeModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Handler {

    @Override
    public void save(Serializable serializable) throws FileNotFoundException, IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("FamilyTree.out"));// OOP/Homework/homeWork/src/familyTreeModel/
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
    }

    @Override
    public FamilyTree download() throws ClassNotFoundException, IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("FamilyTree.out"));// C:/Users/User/Desktop/Java/OOP/Homework/FamilyTree.out
        FamilyTree FamilyTree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return FamilyTree;
    }

}
