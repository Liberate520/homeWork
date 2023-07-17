package ru.gb.family_tree;

import java.io.*;

public class FileHandler implements Writable{
    public void save (Serializable object) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("family_tree.out"));
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }

    public Object load() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("family_tree.out"));
        FamilyTree familyTree = (FamilyTree) objectInputStream.readObject();
        for (Human human: familyTree.getMembers()){
            human.getName();
        }
        objectInputStream.close();
        return familyTree;
    }
}
