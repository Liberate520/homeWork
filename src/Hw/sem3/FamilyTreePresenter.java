package Hw.sem3;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class FamilyTreePresenter<T> {
    private FamilyTree<T> familyTree;
    private Scanner scanner;
    private DataStorage<T> dataStorage;
    private String filename;

    public FamilyTreePresenter(DataStorage<T> dataStorage, String filename) {
        this.dataStorage = dataStorage;
        this.filename = filename;
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== Genealogy Tree App ===");

        T root = null;

        while (true) {
            printMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    root = createPerson();
                    familyTree = new FamilyTreeImpl<>(root);
                    System.out.println("Root person added successfully.");
                    break;
                case 2:
                    if (root != null) {
                        T child = createPerson();
                        familyTree.addChild(root, child);
                        System.out.println("Child added successfully.");
                    } else {
                        System.out.println("Please add a root person first.");
                    }
                    break;
                case 3:
                    if (root != null) {
                        displayMembers();
                    } else {
                        System.out.println("Please add a root person first.");
                    }
                    break;
                case 4:
                    if (root != null) {
                        sortByName();
                        displayMembers();
                    } else {
                        System.out.println("Please add a root person first.");
                    }
                    break;
                case 5:
                    if (root != null) {
                        sortByBirthDate();
                        displayMembers();
                    } else {
                        System.out.println("Please add a root person first.");
                    }
                    break;
                case 6:
                    saveToFile();
                    break;
                case 7:
                    loadFromFile();
                    displayMembers();
                    break;
                case 0:
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private T createPerson() {
        System.out.println("Enter person details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Gender (MALE/FEMALE): ");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Birth Date (yyyy-MM-dd): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        return (T) new Person(name, gender, birthDate);
    }

    private void displayMembers() {
        List<T> members = familyTree.getAllMembers();
        System.out.println("\nGenealogy Tree Members:");
        for (T member : members) {
            System.out.println(member);
        }
    }

    private void sortByName() {
        familyTree.sort(Comparator.comparing(p -> ((Person) p).getName()));
    }

    private void sortByBirthDate() {
        familyTree.sort(Comparator.comparing(p -> ((Person) p).getBirthDate()));
    }

    private void saveToFile() {
        familyTree.saveToFile(dataStorage, filename);
    }

    private void loadFromFile() {
        familyTree.loadFromFile(dataStorage, filename);
    }

    private void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add child");
        System.out.println("2. Display members");
        System.out.println("3. Sort by name");
        System.out.println("4. Sort by birth date");
        System.out.println("5. Save to file");
        System.out.println("6. Load from file");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}