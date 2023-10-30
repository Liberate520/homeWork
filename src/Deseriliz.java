package HomeWork.familyTree.homeWork22_10_23.src;
import HomeWork.familyTree.homeWork22_10_23.src.human.Human;
import HomeWork.familyTree.homeWork22_10_23.src.tree.FamilyTree;

import java.io.*;

public class Deseriliz {
    public static void main(String[] args) {
        FamilyTree familyTree;
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("Human.bin"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            familyTree = (FamilyTree) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(familyTree.getHumanListInfo());
    }
}
