package Homework_004.model;

import java.io.*;

public class Writer {
        public Writer() {       
}

public void save(Writable writable) throws ClassNotFoundException, IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("Homework_004\\familyTree.out"));
        objectOutputStream.writeObject(writable);
        objectOutputStream.close();
        }

public FamilyTree read() throws ClassNotFoundException, IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("Homework_004\\familyTree.out"));
        FamilyTree familyTreeRestored = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return familyTreeRestored;
        }

}
