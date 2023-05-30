package tree;

import java.io.*;

public class FileHandler implements Serializable {

    public void saveObject(Object ob) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("familytree.out"));
        objectOutputStream.writeObject(ob);
        objectOutputStream.close();
    }

    public Object loadObject() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
            new FileInputStream("familytree.out"));

        return objectInputStream.readObject();
    }
}
