package FamilyTree;


import FamilyTree.Tree.FamilyTree;
import FamilyTree.Human.Gender;
import FamilyTree.Human.Human;
import FamilyTree.Human.MotFath;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree(1);
        List<String> kids = new ArrayList<>(Arrays.asList("Иван Поп", "Ева Поп"));
        Human human1 = new Human(Gender.Male, 26, "Стёпа", "Поп", MotFath.Father, kids);
        Human human2 = new Human(Gender.Female, 23, "Ольга", "Поп", MotFath.Mother, kids);
        Human human3 = new Human(Gender.Male, 12, "Стёпа", "Поп", MotFath.Father, null);
        Human human4 = new Human(Gender.Female, 10, "Ева", "Поп", MotFath.Child, null);
        tree.addHuman(human1);
        tree.addHuman(human2);
        tree.addHuman(human3);
        tree.addHuman(human4);
        System.out.println(tree.getHumanInfo());
    }
}


