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

        familyTree.addChild(john, tom);
        tom.setFather(john);
        tom.setMother(jane);

        FileHandler fileHandler = new FileHandler(familyTree);

        try {
            fileHandler.saveToFile("family_tree.dat");

            FamilyTree loadedFamilyTree = fileHandler.loadFromFile("family_tree.dat");
            familyTree = loadedFamilyTree;

            List<Person> allMembers = familyTree.getAllMembers();
            for (Person person : allMembers) {
                System.out.println("Name: " + person.getName());
                System.out.println("Gender: " + person.getGender());
                System.out.println("Birth Date: " + person.getBirthDate());
                System.out.println("Death Date: " + person.getDeathDate());
                System.out.println("Father: " + (person.getFather() != null ? person.getFather().getName() : "Unknown"));
                System.out.println("Mother: " + (person.getMother() != null ? person.getMother().getName() : "Unknown"));
                System.out.println("Children: " + person.getChildren().size());
                System.out.println("--------------------");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}