package Model.Tree;

import Model.FamilyMember;
import Model.Relationship;
import Model.RelationshipType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyMember> implements FamilyTreeInterface<T>, Serializable, Iterable<T> {
    private List<T> members;

    public FamilyTree(List<T> members) {
        this.members = members;
    }
    @Override
    public void addPerson(T familyMember) {
        members.add(familyMember);
    }
    @Override
    public List<T> getAllPeople() {
        return members;
    }
    @Override
    public void addRelationship(T familyMember1, T familyMember2, RelationshipType type) {
        familyMember1.addRelationship(type, familyMember2);
        // Теперь создаем обратную связь
        RelationshipType oppositeType = getOppositeRelationship(type);
        familyMember2.addRelationship(oppositeType, familyMember1);
    }

    // Метод для получения обратной связи
    private RelationshipType getOppositeRelationship(RelationshipType type) {
        switch (type) {
            case SPOUSE:
                return RelationshipType.SPOUSE;
            case FATHER, MOTHER:
                return RelationshipType.CHILD;
            case CHILD:
                return RelationshipType.FATHER; // В зависимости от вашей логики может быть и MOTHER
            case ANCESTOR:
                return RelationshipType.ANCESTOR;
            case SIBLING:
                return RelationshipType.SIBLING;
            default:
                throw new IllegalArgumentException("Unknown relationship type: " + type);
        }
    }

    @Override
    public List<Relationship> getRelationships(T familyMember) {
        return familyMember.getRelationships();
    }
    @Override
    public List<Relationship> getAllRelationships() {
        List<Relationship> relationships = new ArrayList<>();

        for (FamilyMember<T> member : members) {
            relationships.addAll(member.getRelationships());
        }
        return relationships;
    }
    @Override
    public int size() {
        return members.size();
    }
    @Override
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return members.get(index);
    }
    @Override
    public void sortByName() {
        members.sort(Comparator.comparing(FamilyMember::getFullName));
    }
    @Override
    public void sortByBirthDate() {
        members.sort(Comparator.comparing(FamilyMember::getBirthDate));
    }
    @Override
    public void sortByAge() {
        members.sort(Comparator.comparingInt(FamilyMember::getAge));
    }
    @Override
    public void sortByDeathDate() {
        members.sort((m1, m2) -> {
            LocalDate deathDate1 = m1.getDeathDate();
            LocalDate deathDate2 = m2.getDeathDate();
            if (deathDate1 == null && deathDate2 == null) {
                return 0; // Если оба null, то считаем их равными
            } else if (deathDate1 == null) {
                return 1; // Если только deathDate1 null, то считаем m1 больше
            } else if (deathDate2 == null) {
                return -1; // Если только deathDate2 null, то считаем m2 больше
            }
            return deathDate1.compareTo(deathDate2);
        });
    }
    @Override
    public void sortByGender() {
        members.sort(Comparator.comparing(FamilyMember::getGender));
    }
    @Override
    public void sortByRelationshipsCount() {
        members.sort(Comparator.comparingInt(person -> person.getRelationships().size()));
    }
    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }
}
