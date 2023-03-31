package Class;
import java.io.*;
import Interface.SaveLoad;

public class SaveRestore implements SaveLoad {
    @Override
    public void Save (Tree treeToSave, String path) {

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
    public Tree Load(String path) {
        Tree treeRestored = new Tree();
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(
                    new FileInputStream(path));
            treeRestored = (Tree) objectInputStream.readObject();
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
