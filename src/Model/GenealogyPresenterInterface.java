package Model;

import Model.Tree.FamilyTree;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface GenealogyPresenterInterface {
    void addFamilyMember(FamilyMember familyMember);
    List<FamilyMember> getFamilyMembers();
    FamilyTree<FamilyMember> getFamilyTree();
    int getNextAvailableId();
    void sortFamilyTreeByName();
    void sortFamilyTreeByBirthDate();
    void sortFamilyTreeByAge();

    void sortFamilyTreeByGender();
    void sortFamilyTreeByRelationshipsCount();
    void addRelationship(FamilyMember familyMember1, FamilyMember familyMember2, RelationshipType type);
    void loadFamilyTree() throws IOException, ClassNotFoundException;
    void saveFamilyTree() throws IOException;
    FamilyMember saveFamilyMember(String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate) throws IOException;
}
