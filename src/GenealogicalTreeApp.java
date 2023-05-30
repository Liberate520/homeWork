

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenealogicalTreeApp {
    private static GenealogicalTree tree;

    public static void main(String[] args) {
        tree = new GenealogicalTree();
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
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

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

        System.out.print("Enter the person's gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter the person's date of birth: ");
        String dateOfBirth = scanner.nextLine();

        System.out.print("Enter the person's date of death (leave blank if alive): ");
        String dateOfDeath = scanner.nextLine();

        Person person = new Person(name, gender, dateOfBirth, dateOfDeath);
        tree.addPerson(person);

        System.out.println("Person added successfully!");
    }

    private static void addRelationship(Scanner scanner) {
        System.out.println("Adding a Relationship");
        System.out.println("---------------------");

        System.out.print("Enter the name of the spouse: ");
        String spouseName = scanner.nextLine();

        System.out.print("Enter the name of the parent: ");
        String parentName = scanner.nextLine();

        System.out.print("Enter the number of children: ");
        int numChildren = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        List<Person> children = new ArrayList<>();
        for (int i = 0; i < numChildren; i++) {
            System.out.print("Enter the name of child " + (i + 1) + ": ");
            String childName = scanner.nextLine();
            Person child = findPerson(childName);
            if (child != null) {
                children.add(child);
            } else {
                System.out.println("Child not found. Relationship not created.");
                return;
            }
        }

        Person spouse = findPerson(spouseName);
        Person parent = findPerson(parentName);

        if (spouse == null || parent == null) {
            System.out.println("Spouse or parent not found. Relationship not created.");
            return;
        }

        Relationship relationship = new Relationship(spouse, parent, children);
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
            System.out.println(person.getName());
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




