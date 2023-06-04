package tree;

import java.io.*;

public class FileHandler implements  Load,Save {

    public void save(String path, Object obj) throws IOException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path));


        objectOutputStream.writeObject(obj);
        objectOutputStream.close();

    }

    public Object load
            (String path, Object obj) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path));


        obj = objectInputStream.readObject();
        objectInputStream.close();
        return obj;
    }


    @Override
    public Serializable load(String path, Serializable obj) {
        return null;
    }

    @Override
    public void save(String path) {

    }
}
