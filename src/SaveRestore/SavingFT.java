package src.SaveRestore;

import src.FamilyTree.FamilyTree;

import java.io.*;

public class SavingFT implements Serializable{
    private FamilyTree people;

    public SavingFT(FamilyTree people){
        this.people = people;
    }

    public FamilyTree getPeople() {
        return people;
    }

    public static void saveToFile(FamilyTree tree) throws IOException {
        SavingFT sFT = new SavingFT(tree);
        FileOutputStream fileOutStream = new FileOutputStream("sFT.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutStream);
        objectOutputStream.writeObject(sFT);
        objectOutputStream.close();
        System.out.println("\nThe Family Tree is saved to sFT.ser\n");
    }
    public static FamilyTree restoreFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInStream = new FileInputStream("sFT.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInStream);
        SavingFT people = (SavingFT) objectInputStream.readObject();
        FamilyTree family = people.getPeople();
        family.getList();
        System.out.println("\nThe Family Tree has been restored\n");
        return family;
    }

}