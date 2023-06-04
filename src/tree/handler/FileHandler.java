package tree.handler;

import java.io.*;

public class FileHandler implements SaveReadable {

    public void saveObject(Serializable ob) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("familytree.out"));
        objectOutputStream.writeObject(ob);
        objectOutputStream.close();
    }

    public Serializable loadObject() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
            new FileInputStream("familytree.out"));

        return (Serializable) objectInputStream.readObject();
    }
}
