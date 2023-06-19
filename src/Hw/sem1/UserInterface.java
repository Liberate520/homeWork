package Hw.sem1;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

class UserInterface {
    private FamilyTree<Person> familyTree;
    private Scanner scanner;
    private FileHandler<FamilyTree<Person>> fileHandler;

    public UserInterface() {
        this.familyTree = null;
        this.scanner = new Scanner(System.in);
        this.fileHandler = new FileHandler<>();
    }

    public void start() {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createFamilyTree();
                    break;
                case 2:
                    addChild();
                    break;
                case 3:
                    displayMembers();
                    break;
                case 4:
                    sortByName();
                    break;
                case 5:
                    sortByBirthDate();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
        System.out.println("Exiting the program.");
    }

    private void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Create Family Tree");
        System.out.println("2. Add Child");
        System.out.println("3. Display Family Tree Members");
        System.out.println("4. Sort by Name");
        System.out.println("5. Sort by Birth Date");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private void createFamilyTree() {
        System.out.print("Enter root person's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter root person's gender (MALE/FEMALE): ");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Enter root person's birth date (YYYY-MM-DD): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        Person rootPerson = new Person(name, gender, birthDate, null);
        familyTree = new FamilyTree<>(rootPerson);

        System.out.println("Family Tree created successfully.");
    }

    private void addChild() {
        if (familyTree == null) {
            System.out.println("No Family Tree created yet. Please create a Family Tree first.");
            return;
        }

        System.out.print("Enter parent's name: ");
        String parentName = scanner.nextLine();
        System.out.print("Enter child's name: ");
        String childName = scanner.nextLine();
        System.out.print("Enter child's gender (MALE/FEMALE): ");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Enter child's birth date (YYYY-MM-DD): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        Person parent = findPerson(parentName);
        if (parent != null) {
            Person child = new Person(childName, gender, birthDate, null);
            familyTree.addChild(parent, child);
            System.out.println("Child added successfully.");
        } else {
            System.out.println("Parent not found. Please enter a valid parent's name.");
        }
    }

    private void displayMembers() {
        if (familyTree == null) {
            System.out.println("No Family Tree created yet. Please create a Family Tree first.");
            return;
        }

        System.out.println("Family Tree Members:");
        for (Person person : familyTree) {
            System.out.println(person);
        }
    }

    private void sortByName() {
        if (familyTree == null) {
            System.out.println("No Family Tree created yet. Please create a Family Tree first.");
            return;
        }

        familyTree.sortByName();
        System.out.println("Family Tree sorted by name.");
    }

    private void sortByBirthDate() {
        if (familyTree == null) {
            System.out.println("No Family Tree created yet. Please create a Family Tree first.");
            return;
        }

        familyTree.sortByBirthDate();
        System.out.println("Family Tree sorted by birth date.");
    }

    private Person findPerson(String name) {
        for (Person person : familyTree) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }

    public void saveFamilyTree(String fileName) {
        try {
            fileHandler.saveToFile(fileName, familyTree);
            System.out.println("Family Tree saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving Family Tree: " + e.getMessage());
        }
    }

    public void loadFamilyTree(String fileName) {
        try {
            familyTree = fileHandler.loadFromFile(fileName);
            System.out.println("Family Tree loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading Family Tree: " + e.getMessage());
        }
    }
}
