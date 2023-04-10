package filesystem.classes;
import java.io.*;

import filesystem.interfaces.SaveLoad;
import tree.classes.Tree;
import tree.interfaces.iTree;

public class SaveRestore<E> implements SaveLoad<E> {
    @Override
    public void save (iTree<E> treeToSave, String path) {

        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(path));
            objectOutputStream.writeObject(treeToSave);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //throw new UnsupportedOperationException("Unimplemented method 'Save'");
    }

    @Override
    public iTree<E> load(String path) {
        iTree<E> treeRestored = new Tree<E>();
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(
                    new FileInputStream(path));
            treeRestored = (iTree<E>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //throw new UnsupportedOperationException("Unimplemented method 'Load'");
        return treeRestored;
    }

}
