package family_tree;

import family_tree.family_tree.FamilyTree;

import java.io.*;

public class FileHandler implements Writable {

    @Override
    public void saveFile(FamilyTree tree,String path) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(path));
            objectOutputStream.writeObject(tree);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public FamilyTree loadFile(String path) {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(
                    new FileInputStream(path));
            FamilyTree tree = (FamilyTree) objectInputStream.readObject();
            objectInputStream.close();
            return tree;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
