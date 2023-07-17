package ru.gb.family_tree.model.save_print_file;

import java.io.*;

public class FileHandler implements Writeable {

    @Override
    public boolean save(Serializable serializable, String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object read(String filePath){
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return objectInputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
