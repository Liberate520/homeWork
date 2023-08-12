package ru.gb.model.writer;

import java.io.*;

public class FileHandler<T> implements Writable<T> {

    public void save (T familyTree) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("family_tree.out"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }
    @SuppressWarnings("unchecked")
    public T load() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("family_tree.out"));
        T familyTree = (T) objectInputStream.readObject();
        objectInputStream.close();
        return familyTree;
    }
}