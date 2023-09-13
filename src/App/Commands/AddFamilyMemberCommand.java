package App.Commands;

import App.Command;
import Model.GenealogyPresenterInterface;
import Model.FamilyMember;
import Model.Gender;
import Model.RelationshipType;
import Model.Tree.FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class AddFamilyMemberCommand implements Command {
    private final GenealogyPresenterInterface presenter;
    private final BufferedReader reader;

    public AddFamilyMemberCommand(GenealogyPresenterInterface presenter, BufferedReader reader) {
        this.presenter = presenter;
        this.reader = reader;
    }

    @Override
    public void execute() {
        try {
            System.out.println("Enter Family Member Details:");
            System.out.print("First Name: ");
            String firstName = reader.readLine();
            System.out.print("Last Name: ");
            String lastName = reader.readLine();
            System.out.print("Gender (MALE/FEMALE): ");
            String genderStr = reader.readLine();
            Gender gender = Gender.valueOf(genderStr.toUpperCase());
            System.out.print("Birth Date (yyyy-MM-dd): ");
            LocalDate birthDate = LocalDate.parse(reader.readLine());

            System.out.print("Death Date (yyyy-MM-dd, or 'N/A' for alive): ");
            String deathDateStr = reader.readLine();
            LocalDate deathDate = null;
            if (!deathDateStr.equalsIgnoreCase("N/A")) {
                try {
                    deathDate = LocalDate.parse(deathDateStr);
                } catch (DateTimeParseException ex) {
                    System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                    return;
                }
            }
            FamilyMember newMember = presenter.saveFamilyMember(firstName, lastName, gender, birthDate, deathDate);
            presenter.addFamilyMember(newMember);

            // Добавление отношений
            addRelationships(newMember);

            System.out.println("Family Member added successfully.");

            presenter.saveFamilyTree();
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
    }

    private void addRelationships(FamilyMember newMember) throws IOException {
        boolean addMoreRelationships = true;
        while (addMoreRelationships) {
            addRelationship(newMember);

            System.out.print("Add more relationships (yes/no): ");
            String addRelationshipsChoice = reader.readLine().toLowerCase();

            if (!addRelationshipsChoice.equals("yes")) {
                addMoreRelationships = false;
            }
        }
    }

    private void addRelationship(FamilyMember newMember) throws IOException {
        System.out.println("Select Relationship Type:");
        RelationshipType relationshipType = selectRelationshipType();

        System.out.println("Select Existing Family Member to Establish Relationship With:");
        FamilyMember existingMember = selectExistingFamilyMember();

        newMember.addRelationship(relationshipType, existingMember);

        System.out.println("Relationship added successfully.");
    }

    private RelationshipType selectRelationshipType() throws IOException {
        while (true) {
            System.out.println("1. SPOUSE");
            System.out.println("2. FATHER");
            System.out.println("3. MOTHER");
            System.out.println("4. CHILD");
            System.out.println("5. ANCESTOR");
            System.out.println("6. SIBLING");
            System.out.print("Enter the number for Relationship Type: ");

            int choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1 -> {
                    return RelationshipType.SPOUSE;
                }
                case 2 -> {
                    return RelationshipType.FATHER;
                }
                case 3 -> {
                    return RelationshipType.MOTHER;
                }
                case 4 -> {
                    return RelationshipType.CHILD;
                }
                case 5 -> {
                    return RelationshipType.ANCESTOR;
                }
                case 6 -> {
                    return RelationshipType.SIBLING;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private FamilyMember selectExistingFamilyMember() throws IOException {
        FamilyTree<FamilyMember> familyTree = presenter.getFamilyTree();
        System.out.println("Select a Family Member:");

        int index = 1;
        for (FamilyMember familyMember : familyTree) {
            System.out.println(index + ". " + familyMember.getFullName());
            index++;
        }

        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(reader.readLine());
                if (choice >= 1 && choice <= familyTree.size()) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        // Индексация начинается с 0, поэтому вычитаем 1
        return familyTree.get(choice - 1);
    }
    @Override
    public String getDescription() {
        return "Add Family Member";
    }
}
