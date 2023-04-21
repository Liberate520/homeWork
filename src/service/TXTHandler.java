package service;

import families.Family;
import families.Writable;

import java.io.*;

public class TXTHandler implements Writable {
    @Override
    public void save(Serializable obj) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("lib.txt"));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
    }

    @Override
    public Family loadFamily() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("lib.txt"));
        Family FamilyRestored = (Family) objectInputStream.readObject();
        objectInputStream.close();
        return FamilyRestored;
    }
}
