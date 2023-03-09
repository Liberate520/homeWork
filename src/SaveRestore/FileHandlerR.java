package src.SaveRestore;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class FileHandlerR implements Read {
    private final String path;

    public FileHandlerR() {
        this.path = "sFT.ser";
    }


    @Override
    public Object read() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(path));
            Object obj = objectInputStream.readObject();
            objectInputStream.close();
            return obj;
        } catch (Exception e) {
            System.out.println("Could not read from file");
        }
        return null;
    }
}
