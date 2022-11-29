package IO;

import java.io.*;

public class IO {
    public <E> void toFile(E element, String path) {
        try {
            OutputStream outStream = new FileOutputStream(path);
            ObjectOutputStream objectOutStream = new ObjectOutputStream(outStream);
            objectOutStream.writeObject(element);
            outStream.close();
            System.out.println("Saved successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object fromFile(String path) {
        FileInputStream freader;
        Object element = new Object();
        try {
            freader = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(freader);
            element = objectInputStream.readObject();
            System.out.println("Loaded successfully");
            return element;
        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return element;
    }
}