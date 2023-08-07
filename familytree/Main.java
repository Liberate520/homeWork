package homeWork.familytree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FamilyTreeModel model = new FamilyTreeModelImpl();
        FamilyTreeView view = new FamilyTreeViewImpl();
        FamilyTreePresenter presenter = new FamilyTreePresenterImpl(model, view);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            view.displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter date of birth (yyyy-MM-dd): ");
                    String dateOfBirth = scanner.nextLine();
                    System.out.print("Enter gender (MALE or FEMALE): ");
                    String genderStr = scanner.nextLine();
                    Human.Gender gender = Human.Gender.valueOf(genderStr.toUpperCase());

                    presenter.onAddMember(name, dateOfBirth, gender);
                    break;
                case 2:
                    presenter.onDisplayFamilyTree();
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
}
