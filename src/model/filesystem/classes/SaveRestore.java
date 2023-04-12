package model.filesystem.classes;
import java.io.*;

import model.filesystem.interfaces.SaveLoad;
import model.tree.classes.Tree;
import model.tree.interfaces.iTree;

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
        return treeRestored;
    }

}
