package Model.Tree;

import Model.FamilyMember;
import Model.Relationship;
import Model.RelationshipType;

import java.util.List;

public interface FamilyTreeInterface<T extends FamilyMember>  {
    void addPerson(T familyMember);
    List<T> getAllPeople();
    void addRelationship(T familyMember1, T familyMember2, RelationshipType type);
    List<Relationship> getRelationships(T familyMember);
    List<Relationship> getAllRelationships();

    int size();

    T get(int index);

    void sortByName();
    void sortByBirthDate();
    void sortByAge();
    void sortByDeathDate();
    void sortByGender();
    void sortByRelationshipsCount();
}


