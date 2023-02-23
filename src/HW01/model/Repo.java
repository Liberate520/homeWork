package HW01.model;

import HW01.model.FileData;

import java.io.*;

public class Repo implements FileData {

    @Override
    public void save(Serializable serializable, String filename) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
    }

    @Override
    public Object read(String filename) throws IOException, ClassNotFoundException {
        Object result = new Object();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename));
        result = objectInputStream.readObject();
        objectInputStream.close();
        return result;
    }
}
