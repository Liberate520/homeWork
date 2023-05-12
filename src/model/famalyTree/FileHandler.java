package model.famalyTree;

import java.io.*;

public class FileHandler implements Savable{
    @Override
    public void save(Serializable serializable, String path) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(serializable);
        } catch (Exception e) {
        }
    }

    @Override
    public Object upload(String path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            return objectInputStream.readObject();
        } catch (Exception e) {
        }
        return null;
    }
}
