package App;

import Model.*;
import Model.Tree.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class ConsoleUI {
    private GenealogyPresenter presenter;
    private BufferedReader reader;

    public ConsoleUI(GenealogyPresenter presenter) {
        this.presenter = presenter;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void start() {
        try {
            presenter.loadFamilyTree(); // Перенесли загрузку в модель
            System.out.println("Family Tree loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading Family Tree: " + e.getMessage());
        }

        while (true) {
            System.out.println("Genealogy App Menu:");
            System.out.println("1. Add Family Member");
            System.out.println("2. Display Family Tree");
            System.out.println("3. Display All Relationships");
            System.out.println("4. Sort and Display Family Tree");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        addFamilyMember();
                        break;
                    case 2:
                        displayFamilyTree();
                        break;
                    case 3:
                        displayAllRelationships();
                        break;
                    case 4:
                        displaySortedFamilyTree();
                        break;
                    case 5:
                        saveAndExit();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private void addFamilyMember() throws IOException {
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
                case 1:
                    return RelationshipType.SPOUSE;
                case 2:
                    return RelationshipType.FATHER;
                case 3:
                    return RelationshipType.MOTHER;
                case 4:
                    return RelationshipType.CHILD;
                case 5:
                    return RelationshipType.ANCESTOR;
                case 6:
                    return RelationshipType.SIBLING;
                default:
                    System.out.println("Invalid choice. Please try again.");
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

    private void displayFamilyTree() {
        FamilyTree<FamilyMember> familyTree = presenter.getFamilyTree();

        System.out.println("All People:");
        for (FamilyMember familyMember : familyTree) {
            System.out.println(formatFamilyMember(familyMember));
        }
    }

    private void displayAllRelationships() {
        FamilyTree<FamilyMember> familyTree = presenter.getFamilyTree();
        List<Relationship> allRelationships = familyTree.getAllRelationships();

        System.out.println("All Relationships:");
        for (Relationship relationship : allRelationships) {
            System.out.println(formatRelationship(relationship));
        }
    }

    private void displaySortedFamilyTree() {
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
                case 1:
                    presenter.sortFamilyTreeByName();
                    break;
                case 2:
                    presenter.sortFamilyTreeByBirthDate();
                    break;
                case 3:
                    presenter.sortFamilyTreeByAge();
                    break;
                case 4:
                    presenter.sortFamilyTreeByGender();
                    break;
                case 5:
                    presenter.sortFamilyTreeByRelationshipsCount();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            displayFamilyTree();
        } catch (NumberFormatException | IOException e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private String formatRelationship(Relationship relationship) {
        return String.format("%s - %s - %s",
                relationship.getPerson1().getFullName(),
                relationship.getType(),
                relationship.getPerson2().getFullName());
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
    private void saveAndExit() {
        try {
            presenter.saveFamilyTree(); // Сохранение семейного дерева
            System.out.println("Family Tree saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving Family Tree: " + e.getMessage());
        } finally {
            System.out.println("Goodbye!");
            System.exit(0); // Завершаем работу приложения
        }
    }
}
