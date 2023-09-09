package Model;

import Model.Tree.*;
import Fileworks.*;


import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class GenealogyPresenter {
    private final FamilyTree<FamilyMember> model;
    private FamilyTreeFileManager fileManager;

    public GenealogyPresenter(FamilyTree<FamilyMember> model) {
        this.model = model;
        this.fileManager = new FamilyTreeFileManager();
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

    public void sortFamilyTreeByDeathDate() {
        model.sortByDeathDate();
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
    public void addFamilyMember(String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate) throws IOException {
        newMember = new FamilyMember(
                getNextAvailableId(),
                firstName,
                lastName,
                gender,
                birthDate,
                deathDate,
                null
        );



    }
    public FamilyMember getNewMember() {
        return newMember;
    }

    public FamilyMember saveFamilyMember(String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate) throws IOException {
        FamilyMember Member = new FamilyMember(
                getNextAvailableId(),
                firstName,
                lastName,
                gender,
                birthDate,
                deathDate,
                null
        );
        return Member;
    }
    // Другие методы для управления данными
}
