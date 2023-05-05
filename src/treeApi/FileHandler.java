package src.treeApi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Writable {

    private static Writable file;

    public static Writable getFile() {
        if (file == null) {
            file = new FileHandler();
        }
        return file;
    }

    @Override
    public void outPut(Serializable serializable) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("file.txt"))) {
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object inPut() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("file.txt"))) {
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
