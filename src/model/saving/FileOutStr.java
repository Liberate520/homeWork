package model.saving;

import model.familyTree.FamilyTree;
import model.person.Person;

import java.io.*;

public class FileOutStr implements Savable {
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

    @Override
    public void savePersonAs(Person person, String path) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path));
        objectOutputStream.writeObject(person);
        objectOutputStream.close();
        System.out.println("Person is saved.");
    }

    @Override
    public Person getPersonFrom(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path));
        Person personRestored = (Person) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println("Person is restored.");
        return personRestored;
    }
}
