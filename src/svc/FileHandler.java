package svc;

import tree.FamilyTree;

import java.io.*;

public class FileHandler implements Writable {
    @Override
    public void save(Serializable serializable) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("./src/svc/family.out"));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
        System.out.println("Сохранено");
    }

    @Override
    public FamilyTree read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("./src/svc/family.out"));
        FamilyTree family = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return family;
    }
}
