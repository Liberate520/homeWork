package familyTree;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MainRestored {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream objIS = new ObjectInputStream(new FileInputStream("familyTree.ser"));
        FamilyTree newTreeRestored = (FamilyTree) objIS.readObject();
        objIS.close();
        System.out.println(newTreeRestored.showAll());
    }
}
