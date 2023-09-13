package Presenter;

import Model.*;
import Model.Tree.*;
import Model.Fileworks.*;


import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class GenealogyPresenter implements GenealogyPresenterInterface, GenealogyService {
    private final FamilyTree<FamilyMember> model;
    private final FamilyTreeFileManager fileManager;

    public GenealogyPresenter(FamilyTree<FamilyMember> model, FamilyTreeFileManager fileManager) {
        this.model = model;
        this.fileManager = fileManager;
    }

    public void addFamilyMember(FamilyMember familyMember) {
        model.addPerson(familyMember);
    }

    public List<FamilyMember> getFamilyMembers() {
        return model.getAllPeople();
    }

    public FamilyTree<FamilyMember> getFamilyTree() {
        return model;
    }

    public int getNextAvailableId() {
        // Находит максимальный ID среди существующих членов семьи и возвращает следующий уникальный ID
        int maxId = 0;
        for (FamilyMember familyMember : model.getAllPeople()) {
            if (familyMember.getId() > maxId) {
                maxId = familyMember.getId();
            }
        }
        return maxId + 1;
    }
    public void sortFamilyTreeByName() {
        model.sortByName();
    }
    public void sortFamilyTreeByBirthDate() {
        model.sortByBirthDate();
    }
    public void sortFamilyTreeByAge() {
        model.sortByAge();
    }

    public void sortFamilyTreeByGender() {
        model.sortByGender();
    }
    public void sortFamilyTreeByRelationshipsCount() {
        model.sortByRelationshipsCount();
    }
    public void addRelationship(FamilyMember familyMember1, FamilyMember familyMember2, RelationshipType type) {
        model.addRelationship(familyMember1, familyMember2, type);
    }
    public void loadFamilyTree() throws IOException, ClassNotFoundException {
        fileManager.loadFamilyTree("family_bush.dat");
    }
    public void saveFamilyTree() throws IOException {
        fileManager.saveFamilyTree(model, "family_bush.dat");
    }
    private FamilyMember newMember;

    public FamilyMember saveFamilyMember(String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        return new FamilyMember(
                getNextAvailableId(),
                firstName,
                lastName,
                gender,
                birthDate,
                deathDate,
                null
        );
    }
    // Другие методы для управления данными
}
