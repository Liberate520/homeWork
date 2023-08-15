package homeWork.familytree;

import java.util.List;
import java.util.Scanner;

public class FamilyTreeViewImpl implements FamilyTreeView {
    private FamilyTreePresenter presenter;

    public FamilyTreeViewImpl(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayMenu() {
        System.out.println("\nFamily Tree Application");
        System.out.println("1. Add a member");
        System.out.println("2. Display the family tree");
        // Add more menu options for other operations
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    @Override
    public void showMembers(List<Human> members) {
        System.out.println("\nFamily Members:");
        for (Human member : members) {
            System.out.println(member);
        }
    }

    // Implement other methods for displaying the user interface and handling user input
}
