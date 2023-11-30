package model.writer;

import model.tree.FamilyTreeItem;
import java.io.*;

public class FileHandler<T extends FamilyTreeItem<T>> implements Writable {
    public boolean save(Serializable serializable, String filePath){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath, true))){
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    public Object read(String filePath){
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            return objectInputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
