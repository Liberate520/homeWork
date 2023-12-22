package model.file_handler;

import java.io.*;

public class FileHandler implements Writable{
    public final String filePath = "src/model/file_handler/tree.txt";

    public boolean save(Serializable serializable) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            outputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object read(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}