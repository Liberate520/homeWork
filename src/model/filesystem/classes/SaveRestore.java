package model.filesystem.classes;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import model.filesystem.interfaces.SaveLoad;

public class SaveRestore<E> implements SaveLoad<E> {
    
    @Override
    public void save (List<E> treeToSave, String path) {
        try {
            FileOutputStream out = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(treeToSave);
            oos.close();
        } catch (Exception e) {
            System.out.println("Problem serializing: " + e);
            //e.printStackTrace();
        }
    }

    @Override
    public List<E> load(String path) {
        List<E> treeRestored = new ArrayList<>();
        try {
            FileInputStream in = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(in);
            treeRestored = (List<E>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println("Problem serializing: " + e);
            //e.printStackTrace();
        }
        return treeRestored;
    }

}
