package model;

import family.FamilyTree;
import person.Person;

import java.io.*;

public class SaveRestoreSerializable<E extends Person> implements SaveAndLoad<E> {
    private final String pathToFile = System.getProperty("user.dir").
            concat(System.getProperty("file.separator"));

    public void save(String fileName, FamilyTree<E> tree) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathToFile.concat(fileName)));
        objectOutputStream.writeObject(tree);
        objectOutputStream.close();
    }

     public FamilyTree<E> load(String fileName) throws ClassNotFoundException, IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathToFile.concat(fileName)));
        FamilyTree<E> tree = (FamilyTree<E>) objectInputStream.readObject();
        objectInputStream.close();
        return tree;
    }
}
