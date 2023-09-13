package App.Commands;

import App.Command;
import Model.GenealogyPresenterInterface;
import Model.FamilyMember;
import Model.Relationship;
import Model.Tree.FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;

public class SortAndDisplayFamilyTreeCommand implements Command {
    private final GenealogyPresenterInterface presenter;
    private final BufferedReader reader;

    public SortAndDisplayFamilyTreeCommand(GenealogyPresenterInterface presenter, BufferedReader reader) {
        this.presenter = presenter;
        this.reader = reader;
    }

    @Override
    public void execute() {
        while (true) {
            System.out.println("Sort Family Tree by:");
            System.out.println("1. Name");
            System.out.println("2. Birth Date");
            System.out.println("3. Age");
            System.out.println("4. Gender");
            System.out.println("5. Relationships Count");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1 -> presenter.sortFamilyTreeByName();
                    case 2 -> presenter.sortFamilyTreeByBirthDate();
                    case 3 -> presenter.sortFamilyTreeByAge();
                    case 4 -> presenter.sortFamilyTreeByGender();
                    case 5 -> presenter.sortFamilyTreeByRelationshipsCount();
                    case 6 -> {
                        return; // Выходим из метода, чтобы вернуться в предыдущее меню
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
                displayFamilyTree();
            } catch (NumberFormatException | IOException e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }


    @Override
    public String getDescription() {
        return "Sort and Display Family Tree";
    }
    private void displayFamilyTree() {
        FamilyTree<FamilyMember> familyTree = presenter.getFamilyTree();

        System.out.println("All People:");
        for (FamilyMember familyMember : familyTree) {
            System.out.println(formatFamilyMember(familyMember));
        }
    }
    private String formatFamilyMember(FamilyMember familyMember) {
        String deathInfo = familyMember.isAlive() ?
                familyMember.getAge() + " years (Alive)" :
                familyMember.getAge() + " years (Died " + familyMember.getYearsSinceDeath() + " years ago)";

        return String.format("Name: %s%nGender: %s%nBirth Date: %s%nDeath Date: %s%n%s%nRelationships:%n%s%n",
                familyMember.getFullName(),
                familyMember.getGender(),
                familyMember.getBirthDate(),
                familyMember.getDeathYear(),
                deathInfo,
                formatRelationships(familyMember));
    }
    private String formatRelationships(FamilyMember familyMember) {
        StringBuilder relationships = new StringBuilder();
        for (Relationship relationship : presenter.getFamilyTree().getRelationships(familyMember)) {
            relationships.append("  ")
                    .append(formatRelationship(relationship))
                    .append("\n");
        }
        return relationships.toString();
    }

    private String formatRelationship(Relationship relationship) {
        return String.format("%s - %s - %s",
                relationship.getPerson1().getFullName(),
                relationship.getType(),
                relationship.getPerson2().getFullName());
    }
}
