package FamilyTree;


import FamilyTree.Human.Human;
import FamilyTree.Human.other.Gender;
import FamilyTree.Human.other.MotFath;
import FamilyTree.Tree.FamilyTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree(1);
        FamilyTree.service.Service service = new FamilyTree.service.Service();
        List<String> children = new ArrayList<>(Arrays.asList("Аня Бебр, Жора Бебр"));
        familyTree.addHuman(new Human(0, Gender.Female, 25, "Таня", "Бебр", MotFath.Mother, children));
        familyTree.addHuman(new Human(1, Gender.Female, 15, "Аня", "Бебр", MotFath.Child, children));
        familyTree.addHuman(new Human(2, Gender.Male, 35, "Костя", "Бебр", MotFath.Father, children));
        familyTree.addHuman(new Human(3, Gender.Male, 5, "Жора", "Бебр", MotFath.Child, children));
        System.out.println(service.getHumanInfo(familyTree));
        familyTree.sortByAge();
        System.out.println(service.getHumanInfo(familyTree));
        familyTree.sortByName();
        System.out.println(service.getHumanInfo(familyTree));
    }
}


