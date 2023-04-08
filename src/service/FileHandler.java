package service;

import javax.imageio.IIOException;
import java.io.*;


public class FileHandler implements Writable {
    @Override
    public void write(Object obj, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        oos.close();
        fos.close();
    }

    @Override
    public Object read(String fileName) throws IOException, ClassNotFoundException {
        Object obj;
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        obj = ois.readObject();
        ois.close();
        fis.close();
        return obj;
    }



}
