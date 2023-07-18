
import java.time.LocalDate;

import Model.familyTree.FamilyTree;
import Model.fileHandlers.FileHandler;
import Model.human.Gender;
import Model.human.Human;
import View.ConsoleUI;

public class Main {
    public static void main(String[] args) {

        // Human human1 = new Human("Alex", LocalDate.of(1914, 7, 28), Gender.Male);
        // Human human2 = new Human("Susan", LocalDate.of(1917, 3, 24), Gender.Female);
        // Human human3 = new Human("Bob", LocalDate.of(1935, 3, 12), Gender.Male);
        // human1.setDeathDate(LocalDate.of(1964, 3, 2));
        // human2.setDeathDate(LocalDate.of(1964, 3, 2));
        // FamilyTree<Human> familyTree = new FamilyTree<Human>();
        // familyTree.createFamily(human1, human2, human3);
        // System.out.println(familyTree.getFamilyTree());

        // Human human4 = new Human("Olga", LocalDate.of(1915, 12, 5), Gender.Female);
        // Human human5 = new Human("Mathew", LocalDate.of(1913, 7, 30), Gender.Male);
        // Human human6 = new Human("Mary", LocalDate.of(1938, 5, 12), Gender.Female);
        // human4.setDeathDate(LocalDate.of(1964, 3, 2));
        // human5.setDeathDate(LocalDate.of(1964, 3, 2));
        // familyTree.createFamily(human4, human5, human6);
        // // System.out.println(familyTree2.getFamilyTree());

        // Human human7 = new Human("Andrew", LocalDate.of(1958, 6, 13), Gender.Male);
        // familyTree.createFamily(human3, human6, human7);
        // System.out.println(familyTree3.getFamilyTree());

        // FamilyTree<Human> restoredFamilyTree = new FamilyTree<Human>();
        // FileHandler fileHandler = new FileHandler();
        // fileHandler.save(familyTree,
        // "Projects_OOP/Projects_OOP_HomeWork/src/FamilyTree.out");
        // restoredFamilyTree = (FamilyTree<Human>)
        // fileHandler.read("Projects_OOP/Projects_OOP_HomeWork/src/FamilyTree.out");
        // System.out.println(restoredFamilyTree.getFamilyTree());
        // restoredFamilyTree.sortByName();
        // System.out.println("Sort by Name:");
        // System.out.println(restoredFamilyTree.getFamilyTree());
        // restoredFamilyTree.sortByBirthDate();
        // System.out.println("Sort by BirthDate:");
        // System.out.println(restoredFamilyTree.getFamilyTree());
        // restoredFamilyTree.sortByAge();
        // System.out.println("Sort by Age:");
        // System.out.println(restoredFamilyTree.getFamilyTree());

        ConsoleUI client1 = new ConsoleUI();
        client1.work();
    }
}
