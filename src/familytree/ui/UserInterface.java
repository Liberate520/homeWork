package familytree.ui;

import familytree.model.FamilyModelTree;
import familytree.model.TreeEntity;

import java.util.Scanner;

public class UserInterface {
    private FamilyModelTree<TreeEntity> tree;
    private java.util.Scanner scanner;

    public UserInterface(FamilyModelTree<TreeEntity> tree) {
        this.tree = tree;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("1. Add Entity");
            System.out.println("2. Sort by Name");
            System.out.println("3. Sort by date of birth");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Add Entity
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter date of birth: ");
                    String dob = scanner.nextLine();
                    tree.addEntity(new TreeEntity(name, dob));
                    System.out.println("Entity added.");
                    break;
                case 2:
                    // Sort by Name
                    tree.sortByName();
                    System.out.println("Sorted by Name.");
                    break;
                case 3:
                    // Sort by date of birth
                    tree.sortByDateOfBirth();
                    System.out.println("Sorted by date of birth.");
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        System.out.println("Goodbye!");
    }
}
