package homeWork.familytree;

import java.util.Scanner;

public class FamilyTreeCLI {
    private Tree<Human> familyTree; // Change 'Human' to 'Dog' or any other class as needed

    public FamilyTreeCLI() {
        familyTree = new Tree<>();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the integer

            switch (choice) {
                case 1:
                    addMember();
                    break;
                case 2:
                    displayFamilyTree();
                    break;
                // Add more operations as needed
                case 0:
                    System.out.println("Exiting Family Tree Application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\nFamily Tree Application");
        System.out.println("1. Add a member");
        System.out.println("2. Display the family tree");
        // Add more menu options for other operations
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addMember() {
        // Code to interact with the user and add a new member to the tree
    }

    private void displayFamilyTree() {
        // Code to display the family tree
    }

    // Add more methods for other operations on the tree
}

