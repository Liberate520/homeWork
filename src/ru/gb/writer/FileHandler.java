package ru.gb.writer;

import ru.gb.family_tree.FamilyTree;
import ru.gb.human.Human;

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
