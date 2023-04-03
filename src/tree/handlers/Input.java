package tree.handlers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import tree.familyTree.FamilyTree;

public class Input {
    public void printIn() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("src\\tree\\log\\Input.out"));
        FamilyTree dadRestored = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
    }
}
