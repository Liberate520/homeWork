package Homework_006.model;

import java.io.*;

public class Writer {
        public Writer() {
        }

        public void save(FamilyTree familyTree) throws ClassNotFoundException, IOException {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                                new FileOutputStream("Homework_006\\familyTree.out"));
                objectOutputStream.writeObject(familyTree);
                objectOutputStream.close();
        }

        public FamilyTree read() throws ClassNotFoundException, IOException {
                ObjectInputStream objectInputStream = new ObjectInputStream(
                                new FileInputStream("Homework_006\\familyTree.out"));
                FamilyTree familyTreeRestored = (FamilyTree) objectInputStream.readObject();
                objectInputStream.close();
                return familyTreeRestored;
}

}
