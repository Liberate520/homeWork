package fam_tree.file_handler;

import fam_tree.valet.Writable;

import java.io.*;


public class FileHandler implements Writable {

    public void save(Serializable serializable, String filePath){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public Object read (String filePath){
        try(ObjectInputStream objectInputStream = new ObjectInputStream( new FileInputStream(filePath))) {
            return objectInputStream.readObject();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
