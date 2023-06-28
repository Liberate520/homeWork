package Hw.sem1;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class FamilyTreePresenter<T> {
    private FamilyTree<T> familyTree;
    private Scanner scanner;
    private DataStorage<FamilyTree<T>> dataStorage;

    public FamilyTreePresenter(FamilyTree<T> familyTree, DataStorage<FamilyTree<T>> dataStorage) {
        this.familyTree = familyTree;
        this.dataStorage = dataStorage;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            printMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    createRootPerson();
                    break;
                case 2:
                    addChild();
                    break;
                case 3:
                    displayFamilyMembers();
                    break;
                case 4:
                    sortByName();
                    break;
                case 5:
                    sortByBirthDate();
                    break;
                case 6:
                    saveDataToFile();
                    break;
                case 7:
                    loadDataFromFile();
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void createRootPerson() {
        System.out.println("\nAdding root person:");
        T person = createPerson();
        familyTree.setRoot(person);
        System.out.println("Root person added successfully.");
    }

    private void addChild() {
        System.out.println("\nAdding a child:");
        T parent = findPersonByName("Enter parent's name:");
        if (parent != null) {
            T child = createPerson();
            familyTree.addChild(parent, child);
            System.out.println("Child added successfully.");
        } else {
            System.out.println("Parent not found.");
        }
    }

    private void displayFamilyMembers() {
        List<T> members = familyTree.getAllMembers();
        System.out.println("\nFamily Members:");
        for (T member : members) {
            System.out.println(member);
        }
    }

    private void sortByName() {
        familyTree.sort(Comparator.comparing(p -> ((Person) p).getName()));
        System.out.println("\nFamily members sorted by name.");
    }

    private void sortByBirthDate() {
        familyTree.sort(Comparator.comparing(p -> ((Person) p).getBirthDate()));
        System.out.println("\nFamily members sorted by birth date.");
    }

    private void saveDataToFile() {
        System.out.println("\nSaving data to file...");
        try {
            System.out.print("Enter filename: ");
            String filename = scanner.nextLine();
            dataStorage.saveToFile(familyTree, filename);
            System.out.println("Data saved to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving data to file: " + e.getMessage());
        }
    }

    private void loadDataFromFile() {
        System.out.println("\nLoading data from file...");
        try {
            System.out.print("Enter filename: ");
            String filename = scanner.nextLine();
            familyTree = dataStorage.loadFromFile(filename);
            System.out.println("Data loaded from file successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred while loading data from file: " + e.getMessage());
        }
    }

    private T createPerson() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        Gender gender = null;
        while (gender == null) {
            System.out.print("Enter gender (MALE or FEMALE): ");
            try {
                gender = Gender.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid gender. Please enter MALE or FEMALE.");
            }
        }

        LocalDate birthDate = null;
        while (birthDate == null) {
            System.out.print("Enter birth date (YYYY-MM-DD): ");
            try {
                birthDate = LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter date in the format YYYY-MM-DD.");
            }
        }

        return (T) new Person(name, gender, birthDate);
    }

    private T findPersonByName(String prompt) {
        System.out.print(prompt);
        String name = scanner.nextLine();
        List<T> members = familyTree.getAllMembers();
        for (T member : members) {
            if (((Person) member).getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }

    private int getUserChoice() {
        int choice = -1;
        try {
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice. Please enter a valid number.");
        }
        return choice;
    }

    private void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add Root Person");
        System.out.println("2. Add Child");
        System.out.println("3. Display Family Members");
        System.out.println("4. Sort by Name");
        System.out.println("5. Sort by Birth Date");
        System.out.println("6. Save Data to File");
        System.out.println("7. Load Data from File");
        System.out.println("0. Exit");
    }
}
