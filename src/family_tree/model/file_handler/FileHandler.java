package family_tree.model.file_handler;

import family_tree.model.file_handler.interfaces.ReadAndWrite;

import java.io.*;

public class FileHandler implements ReadAndWrite {

    public Object read(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path));
        Object obj = objectInputStream.readObject();
        objectInputStream.close();
        return obj;
    }
    public void write(Object obj, String path) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
    }
}
