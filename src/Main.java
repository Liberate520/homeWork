import Human.Gender;
import Human.Human;
import FamilyTree.FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human("Mark", Gender.Male, LocalDate.of(1996, 7, 21));
        Human human2 = new Human("Elena", Gender.Female, LocalDate.of(1969, 12, 24));

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        human1.setSpouse(human2);

        Human child1 = new Human("Soledad", Gender.Female, LocalDate.of(1994, 8, 23));
        Human child2 = new Human("Lujan", Gender.Female, LocalDate.of(1991, 11, 9));
        familyTree.addHuman(child1);
        familyTree.addHuman(child2);

        human1.addChild(child1);
        human1.addChild(child2);
        human2.addChild(child1);
        human2.addChild(child2);

        System.out.println(child1.getSpouse());
        System.out.println(child2.getName());
        System.out.println(child1.getChildren());
        System.out.println(child2.getInfo());
        System.out.println(familyTree.getInfo());

    }
}


