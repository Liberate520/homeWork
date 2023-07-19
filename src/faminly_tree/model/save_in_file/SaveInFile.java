package faminly_tree.model.save_in_file;

import java.io.*;

public class SaveInFile<E extends Serializable> {
    public void write(String path, E obj) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
    }
    public Object readTree(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        Object obj = objectInputStream.readObject();
        objectInputStream.close();
        return obj;
    }
}
