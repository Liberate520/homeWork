package Utils;

import Tree.FamilyTree;

import java.io.*;

public class StorageTree implements Serializable {
    public void writeTree (FamilyTree tree, String fileName) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(fileName));

        objectOutputStream.writeObject(tree);
        objectOutputStream.close();
    }

    public FamilyTree restoreTree (String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(fileName));
        FamilyTree tmp = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return tmp;
    }

}
