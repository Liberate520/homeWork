package tree;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human human0 = new Human();
        Human human1 = new Human("Eryomin", "Mark", "Aleksandrovich", human0, human0);
        Human human2 = new Human("Eryomina", "Eugeniya", "Anatolievna", human0, human0);
        Human human3 = new Human("Eryomina", "Yaroslava", "Markovna", human1, human2);
        Human human4 = new Human("Eryomina", "Aleksandra", "Markovna", human1, human2);


        FamilyTree familyTree = new FamilyTree();
        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);

        System.out.println(familyTree.getHumanList());
        System.out.println();
        System.out.println(familyTree.findHumanByName("mark"));
        System.out.println();
        System.out.println(familyTree);



    }
}
