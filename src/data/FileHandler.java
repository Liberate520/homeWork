package data;

import data.Writable;

import java.io.*;

public class FileHandler implements Writable {
    @Override
    public boolean save(Serializable serializable, String fileName) {
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(fileName))) {
            ous.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object load(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
