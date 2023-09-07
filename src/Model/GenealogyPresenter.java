package Model;

import java.io.IOException;
import java.util.List;

public class GenealogyPresenter {
    private final FamilyTree<FamilyMember> model;

    public GenealogyPresenter(FamilyTree<FamilyMember> model) {
        this.model = model;
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

    public void saveFamilyTree(FamilyTreeFileManager fileManager) throws IOException, ClassNotFoundException {
        fileManager.saveFamilyTree(this.model, "family_bush.dat");
    }

    public void loadFamilyTree(FamilyTreeFileManager fileManager) throws IOException, ClassNotFoundException {
        FamilyTree<FamilyMember> loadedTree = fileManager.loadFamilyTree("family_bush.dat");

    }
    // Другие методы для управления данными
}
