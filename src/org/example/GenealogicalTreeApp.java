package org.example;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;

public class GenealogicalTreeApp {
    public static void main(String[] args) {
        DataStorage<GenealogicalTree<Person>> dataStorage = new BinaryDataStorage<>();

        GenealogicalTree<Person> tree = new GenealogicalTree<>(dataStorage);

        Person john = new Person("John", Gender.MALE, LocalDate.of(1980, 2, 1));
        Person jane = new Person("Jane", Gender.FEMALE, LocalDate.of(1982, 3, 15));
        Person bob = new Person("Bob", Gender.MALE, LocalDate.of(2005, 7, 10));
        Person david = new Person("David", Gender.MALE, LocalDate.of(2010, 6, 5));

        Relationship relationship = new Relationship(john, jane);
        relationship.addChild(bob);
        relationship.addChild(david);

        tree.addPerson(john);
        tree.addPerson(jane);
        tree.addPerson(bob);
        tree.addPerson(david);
        tree.addRelationship(relationship);

        // Save the tree to a file
        String fileName = "genealogical_tree.dat";
        tree.saveTree(fileName);

        // Load the tree from the file
        GenealogicalTree<Person> loadedTree;
        try {
            loadedTree = dataStorage.loadData(fileName);
            if (loadedTree != null) {
                // Displaying the people in the loaded tree
                System.out.println("People in the loaded tree:");
                for (Person person : loadedTree.getPeople()) {
                    System.out.println(person.getName());
                }

                // Sort the people in the loaded tree by name
                loadedTree.sortPeople(Comparator.comparing(Person::getName));

                // Display the sorted people in the loaded tree
                System.out.println("Sorted people in the loaded tree:");
                for (Person person : loadedTree.getPeople()) {
                    System.out.println(person.getName());
                }
            } else {
                System.out.println("Failed to load the tree from file.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading tree from file: " + e.getMessage());
            return;
        }

        printPerson(john, 0);
    }


    public static void printPerson(Person person, int level) {
        String indent = "  ".repeat(level);
        System.out.println(indent + person.getName() + " (gender: " + person.getGender() + ", date of birth: " + person.getDateOfBirth() + ")");

        if (person.getSpouse() != null) {
            System.out.println(indent + "  Spouse: " + person.getSpouse().getName());
        }

        for (Person child : person.getChildren()) {
            System.out.println(indent + "  - " + child.getName() + " (gender: " + child.getGender() + ", date of birth: " + child.getDateOfBirth() + ")");
            System.out.println(indent + "    Father: " + person.getName());
            if (person.getSpouse() != null) {
                System.out.println(indent + "    Mother: " + person.getSpouse().getName());
            }
            printPerson(child, level + 2);
        }
    }

}
