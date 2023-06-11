package model;

import java.io.*;

public class FileHandler implements Savable {

    public void save(Object object, String filename) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(filename + ".out"));
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    };
    public FamilyTree load(String filename) throws IOException, ClassNotFoundException {

        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(filename + ".out"));
        FamilyTree familyTreeRestored = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();

    return familyTreeRestored;
    };
}
