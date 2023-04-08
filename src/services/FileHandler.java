package services;

import java.io.*;

public class FileHandler implements Writable {
    @Override
    public void save(Serializable serializable) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("./src/services/family.out"));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
        System.out.println("Сохранено");
    }

    @Override
    public Object read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("./src/services/family.out"));
        Object family =  objectInputStream.readObject();
        objectInputStream.close();
        return family;
    }
}
