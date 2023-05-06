package module.service;

import module.essence.Essence;
import module.families.Family;
import module.families.Writable;

import java.io.*;

public class TXTHandler<T extends Essence<T>> implements Writable<T> {
    @Override
    public void save(Serializable obj) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("lib.txt"));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
    }

    @Override@SuppressWarnings("unchecked")
    public Family<T> loadFamily() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("lib.txt"));
        return (Family<T>) objectInputStream.readObject();
    }
}
