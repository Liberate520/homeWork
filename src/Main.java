import human.Human;
import human.Gender;
import fam_tree.FamilyTree;
import file_handler.FileHandler;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // FamilyTree tree = testTree();
        // System.out.println(tree);
        // List<Human> humanList = tree.getHumanList();
        // FileHandler.saveToFile(humanList);

        List<Human> loadedHumanList = FileHandler.loadFromFile();
        FamilyTree loadedTree = new FamilyTree(loadedHumanList);
        System.out.println("Loaded Tree:");
        System.out.println(loadedTree);
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
