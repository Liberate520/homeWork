package org.example;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GenealogicalTreeApp {
    private static GenealogicalTree tree;
    private static DataStorage dataStorage;

    public static void main(String[] args) {
        tree = new GenealogicalTree();
        dataStorage = new BinaryDataStorage();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Genealogical Tree App");
        System.out.println("---------------------");

        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Add Person");
            System.out.println("2. Add Relationship");
            System.out.println("3. Get Ancestors");
            System.out.println("4. Get Descendants");
            System.out.println("5. Display All People");
            System.out.println("6. Save Data to File");
            System.out.println("7. Load Data from File");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addPerson(scanner);
                    break;
                case 2:
                    addRelationship(scanner);
                    break;
                case 3:
                    getAncestors(scanner);
                    break;
                case 4:
                    getDescendants(scanner);
                    break;
                case 5:
                    displayAllPeople();
                    break;
                case 6:
                    saveDataToFile(scanner);
                    break;
                case 7:
                    loadDataFromFile(scanner);
                    break;
                case 8:
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addPerson(Scanner scanner) {
        System.out.println("Adding a Person");
        System.out.println("---------------");

        System.out.print("Enter the person's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the person's gender (MALE or FEMALE): ");
        String genderStr = scanner.nextLine();
        Gender gender = Gender.valueOf(genderStr.toUpperCase());

        System.out.print("Enter the person's date of birth (YYYY-MM-DD: ");
        String dateOfBirthStr = scanner.nextLine();
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr);

        System.out.print("Enter the person's date of death (leave blank if alive): ");
        String dateOfDeathStr = scanner.nextLine();
        LocalDate dateOfDeath = dateOfDeathStr.isEmpty() ? null : LocalDate.parse(dateOfDeathStr);

        Person person = new Person(name, gender, dateOfBirth, dateOfDeath);
        tree.addPerson(person);

        System.out.println("Person added successfully!");
    }

    private static void addRelationship(Scanner scanner) {
        System.out.println("Adding a Relationship");
        System.out.println("---------------------");

        System.out.print("Enter the name of the father: ");
        String fatherName = scanner.nextLine();

        System.out.print("Enter the name of the mother: ");
        String motherName = scanner.nextLine();

        System.out.print("Enter the name of the husband: ");
        String husbandName = scanner.nextLine();

        System.out.print("Enter the name of the wife: ");
        String wifeName = scanner.nextLine();

        int numChildren = 0;
        try {
            System.out.print("Enter the number of children: ");
            numChildren = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for the number of children. Relationship not created.");
            return;
        }

        List<Person> children = new ArrayList<>();
        for (int i = 0; i < numChildren; i++) {
            System.out.print("Enter the name of child " + (i + 1) + ": ");
            String childName = scanner.nextLine();
            Person child = findPerson(childName);
            children.add(child);
        }

        Person father = findPerson(fatherName);
        Person mother = findPerson(motherName);
        Person husband = findPerson(husbandName);
        Person wife = findPerson(wifeName);

        if (father == null || mother == null || husband == null || wife == null) {
            System.out.println("One or more persons not found. Relationship not created.");
            return;
        }

        Relationship relationship = new Relationship(father, mother, husband, wife, children);
        tree.addRelationship(relationship);

        System.out.println("Relationship added successfully!");
    }


    private static void getAncestors(Scanner scanner) {
        System.out.println("Get Ancestors");
        System.out.println("-------------");

        System.out.print("Enter the name of the person: ");
        String name = scanner.nextLine();

        Person person = findPerson(name);
        if (person == null) {
            System.out.println("Person not found.");
            return;
        }

        List<Person> ancestors = tree.getAncestors(person);

        System.out.println("Ancestors of " + name + ":");
        for (Person ancestor : ancestors) {
            System.out.println(ancestor.getName());
        }
    }

    private static void getDescendants(Scanner scanner) {
        System.out.println("Get Descendants");
        System.out.println("---------------");

        System.out.print("Enter the name of the person: ");
        String name = scanner.nextLine();

        Person person = findPerson(name);
        if (person == null) {
            System.out.println("Person not found.");
            return;
        }

        List<Person> descendants = tree.getDescendants(person);
        System.out.println("Descendants of " + name + ":");
        for (Person descendant : descendants) {
            System.out.println(descendant.getName());
        }
    }

    private static void displayAllPeople() {
        System.out.println("All People in the Genealogical Tree");
        System.out.println("----------------------------------");

        List<Person> people = tree.getPeople();
        for (Person person : people) {
            System.out.println("Name: " + person.getName());
            System.out.println("Gender: " + person.getGender());
            System.out.println("Date of Birth: " + person.getDateOfBirth());
            if (person.getDateOfDeath() != null) {
                System.out.println("Date of Death: " + person.getDateOfDeath());
            }

            List<Relationship> relationships = tree.findPersonRelationships(person);
            for (Relationship relationship : relationships) {
                if (relationship.getFather() == person) {
                    System.out.println("Father: " + relationship.getFather().getName());
                    System.out.println("Child: " + getChildNames(relationship.getChildren()));
                }
                if (relationship.getMother() == person) {
                    System.out.println("Mother: " + relationship.getMother().getName());
                    System.out.println("Child: " + getChildNames(relationship.getChildren()));
                }
                if (relationship.getChildren().contains(person)) {
                    System.out.println("Father: " + relationship.getFather().getName());
                    System.out.println("Mother: " + relationship.getMother().getName());
                }
            }

            System.out.println("------------------");
        }
        tree.sortPeopleByName();

        System.out.println("\nPeople sorted by name:");
        for (Person person : tree.getPeople()) {
            System.out.println(person.getName() + " - " + person.getDateOfBirth());
        }


        tree.sortPeopleByDateOfBirth();

        System.out.println("\nPeople sorted by date of birth:");
        for (Person person : tree.getPeople()) {
            System.out.println(person.getName() + " - " + person.getDateOfBirth());
        }
    }



    private static String getChildNames(List<Person> children) {
        StringBuilder builder = new StringBuilder();
        for (Person child : children) {
            builder.append(child.getName()).append(", ");
        }
        if (builder.length() > 0) {
            builder.delete(builder.length() - 2, builder.length());
        }
        return builder.toString();
    }

    private static void saveDataToFile(Scanner scanner) {
        System.out.print("Enter the file name to save the data: ");
        String fileName = scanner.nextLine();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            dataStorage.saveData(tree, fileName);

            objectOutputStream.close();
            fileOutputStream.close();

            System.out.println("Data saved successfully to the file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the data to the file.");
            e.printStackTrace();
        }
    }

    private static void loadDataFromFile(Scanner scanner) {
        System.out.print("Enter the file name to load the data: ");
        String fileName = scanner.nextLine();

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            tree = dataStorage.loadData(fileName);

            objectInputStream.close();
            fileInputStream.close();

            System.out.println("Data loaded successfully from the file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while loading the data from the file.");
            e.printStackTrace();
        }
    }

    private static Person findPerson(String name) {
        for (Person person : tree.getPeople()) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }
}



