package model;
import java.io.*;

public class FileHandler implements Writable{
    private final String path;

    public FileHandler(String path) {
        this.path = path;
    }

    public void write(Serializable obj) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(path));
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println("Could not save to file.");
        }
    }

    public Object read() {
        do {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(
                        new FileInputStream(path));
                Object obj = objectInputStream.readObject();
                objectInputStream.close();
                return obj;
            } catch (Exception e) {
                System.out.println("Could not read from file");
            }
        } while (true);

    }
}