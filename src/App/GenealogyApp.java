package App;
import Model.Fileworks.FamilyTreeFileHandler;
import Model.Fileworks.FamilyTreeFileManager;
import Model.*;
import Model.Tree.FamilyTree;
import Presenter.GenealogyPresenter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class GenealogyApp {
    public static void main(String[] args) {
        GenealogyApp app = new GenealogyApp();
        app.run();
    }

    private void run() {
        FamilyTreeFileManager fileManager = new FamilyTreeFileManager(); // Создаем экземпляр FamilyTreeFileManager
        FamilyTree<FamilyMember> familyTree = loadFamilyTreeFromFile(fileManager); // Передаем его в метод загрузки

        if (familyTree == null) {
            List<FamilyMember> familyMembers = createFamilyMembers();
            familyTree = new FamilyTree<>(familyMembers);
        }

        GenealogyPresenter presenter = new GenealogyPresenter(familyTree, fileManager);

        ConsoleUI consoleUI = new ConsoleUI(presenter);
        consoleUI.start();
    }

    private FamilyTree<FamilyMember> loadFamilyTreeFromFile(FamilyTreeFileHandler fileHandler) {
        FamilyTree<FamilyMember> familyTree = null;

        try {
            familyTree = fileHandler.loadFamilyTree("family_bush.dat"); // Используем переданный FileHandler
            System.out.println("Family Tree loaded successfully from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading Family Tree from file: " + e.getMessage());
        }

        return familyTree;
    }
    private List<FamilyMember> createFamilyMembers() {
        // Создаем членов семьи
        FamilyMember familyMember1 = new FamilyMember(1, "John", "Smith", Gender.MALE, LocalDate.of(1971, 8, 8), null, null);
        FamilyMember familyMember2 = new FamilyMember(2, "Alise", "Smith", Gender.FEMALE, LocalDate.of(1974, 3, 5), null, null);
        FamilyMember familyMember3 = new FamilyMember(3, "Ann", "Smith", Gender.FEMALE, LocalDate.of(1998, 9, 11), null, null);
        FamilyMember familyMember4 = new FamilyMember(4, "Will", "Smith", Gender.MALE, LocalDate.of(1901, 1, 2), LocalDate.of(1992, 4, 13), null);
        // Создаем список членов семьи
        List<FamilyMember> familyMembers = new ArrayList<>(List.of(familyMember1, familyMember2, familyMember3, familyMember4));
        // Добавляем отношения
        familyMember1.addRelationship(RelationshipType.SPOUSE, familyMember2);
        familyMember2.addRelationship(RelationshipType.SPOUSE, familyMember1);
        familyMember1.addRelationship(RelationshipType.CHILD, familyMember3);
        familyMember2.addRelationship(RelationshipType.CHILD, familyMember3);
        familyMember3.addRelationship(RelationshipType.FATHER, familyMember1);
        familyMember3.addRelationship(RelationshipType.MOTHER, familyMember2);
        familyMember1.addRelationship(RelationshipType.FATHER, familyMember4);
        return familyMembers;
    }
}