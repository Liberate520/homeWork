package service;

import family.FamilyTree;

import java.io.*;

public class FileHandler implements Writable, Readable {
    @Override
    public void save(Object obj, String path) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
    }

    @Override
    public FamilyTree read(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path));
        FamilyTree treeRestore = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return treeRestore;
    }
}
