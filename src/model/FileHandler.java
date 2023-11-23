package model;

import java.io.*;

public class FileHandler implements Writable, FileInOut{
    private FamilyTree familyTree;

    public FileHandler(FamilyTree familyTree){
        this.familyTree = familyTree;
    }

    public boolean output(){
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("family_tree.out"));
            objectOutputStream.writeObject(familyTree);
            objectOutputStream.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public FamilyTree<Human> input(){
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("family_tree.out"));
            familyTree = (FamilyTree) objectInputStream.readObject();
            objectInputStream.close();
            return familyTree;
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
