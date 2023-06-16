package Hw.sem1;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person john = new Person("John", Gender.MALE, LocalDate.of(1980, 5, 15), null);
        Person jane = new Person("Jane", Gender.FEMALE, LocalDate.of(1982, 9, 22), null);
        Person tom = new Person("Tom", Gender.MALE, LocalDate.of(2005, 3, 10), null);

        FamilyTree familyTree = new FamilyTree(john);
        familyTree.addChild(john, jane);
        familyTree.addChild(john, tom);

        FileHandler fileHandler = new FileHandler(familyTree);

        try {
            fileHandler.saveToFile("family_tree.dat");

            FamilyTree loadedFamilyTree = fileHandler.loadFromFile("family_tree.dat");
            familyTree = loadedFamilyTree;


            familyTree.sortByName();
            System.out.println("Sorted by name:");
            for (Person person : familyTree) {
                System.out.println(person);
            }

            System.out.println();


            familyTree.sortByBirthDate();
            System.out.println("Sorted by birth date:");
            for (Person person : familyTree) {
                System.out.println(person);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}