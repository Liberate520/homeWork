package ru.gb.model.writer;

import ru.gb.model.family_tree.FamilyTree;

import java.io.*;

public class FileHandler implements Writable {
    public void save (Serializable object) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("family_tree.out"));
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }

    public FamilyTree load() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("family_tree.out"));
        FamilyTree familyTree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return familyTree;
    }
}
