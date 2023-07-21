import human.Human;
import human.Gender;
import fam_tree.FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = testTree();
        System.out.println(tree);
    }

    static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        Human vasya = new Human("Vasiliy", Gender.Male, LocalDate.of(1963, 12, 10));
        Human masha = new Human("Mariya", Gender.Female, LocalDate.of(1965, 9, 15));

        tree.add(vasya);
        tree.add(masha);
        tree.setWedding(vasya.getId(), masha.getId());

        Human christina = new Human("Kristina", Gender.Female, LocalDate.of(1988, 7, 5), vasya, masha);
        Human semyon = new Human("Semyon", Gender.Male, LocalDate.of(1991, 2, 5), vasya, masha);
        
        tree.add(christina);
        tree.add(semyon);

        Human larisa = new Human("Larisa", Gender.Female, LocalDate.of(194,9,1));
        larisa.addChild(vasya);
        tree.add(larisa);
        return tree;
    }
}
