package model.fileManager;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.io.FileOutputStream;
import java.io.FileInputStream;

public class FileHandler implements Writable {
    private final String path;

    public FileHandler(String path) {
        this.path = path;
    }

    public void save(Serializable obj) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(path));
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println("...Oops!..");
        }
    }

    public Object load() {
        do {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(
                        new FileInputStream(path));
                Object obj = objectInputStream.readObject();
                objectInputStream.close();
                return obj;
            } catch (Exception e) {
                System.out.println("...Oops!..");
            }
        } while (true);

    }
}