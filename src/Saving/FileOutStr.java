package Saving;

import Program.FamilyTree;

import java.io.*;

public class FileOutStr implements Saveable{
    @Override
    public void saveFamilyTreeAs(FamilyTree familyTree, String path) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
        System.out.println("FamilyTree is saved.");
    }

    @Override
    public FamilyTree getFamilyTreeFrom(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(path));
        FamilyTree familyTreeRestored = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println("FamilyTree is restored.");
        return familyTreeRestored;
    }
}
