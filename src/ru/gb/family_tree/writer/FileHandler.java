package ru.gb.family_tree.writer;

import java.io.*;

public class FileHandler implements Saveble{

    public boolean save(Serializable serializable, String filePath) {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filePath))) {
            os.writeObject(serializable);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object read(String filePath) {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(filePath))) {
            return is.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
