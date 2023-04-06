package classes;
import java.io.*;

import interfaces.SaveLoad;
import interfaces.iTree;

public class SaveRestore implements SaveLoad {
    @Override
    public void save (iTree treeToSave, String path) {

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
    public iTree load(String path) {
        iTree treeRestored = new Tree();
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(
                    new FileInputStream(path));
            treeRestored = (iTree) objectInputStream.readObject();
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
