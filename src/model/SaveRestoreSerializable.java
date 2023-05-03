package model;

import model.family.FamilyTree;
import model.person.Person;

import java.io.*;

public class SaveRestoreSerializable<E extends Person> implements SaveAndLoad<E> {

    public void save(String fileName, FamilyTree<E> tree) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        objectOutputStream.writeObject(tree);
        objectOutputStream.close();
    }

    public FamilyTree<E> load(String fileName) throws ClassNotFoundException, IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        FamilyTree<E> tree = (FamilyTree<E>) objectInputStream.readObject();
        objectInputStream.close();
        return tree;
    }
}
