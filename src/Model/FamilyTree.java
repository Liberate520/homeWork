package Model;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyTree implements Serializable, Iterable<FamilyMember> {
    private List<FamilyMember> members;

    public FamilyTree(List<FamilyMember> members) {
        this.members = members;
    }

    public void addPerson(FamilyMember familyMember) {
        members.add(familyMember);
    }

    public List<FamilyMember> getAllPeople() {
        return members;
    }

    public void addRelationship(FamilyMember familyMember1, FamilyMember familyMember2, RelationshipType type) {
        familyMember1.addRelationship(type, familyMember2);
    }

    public List<Relationship> getRelationships(FamilyMember familyMember) {
        return familyMember.getRelationships();
    }

    public List<Relationship> getAllRelationships() {
        return (List<Relationship>) members.stream()
                .flatMap(person -> person.getRelationships().stream())
                .collect(Collectors.toList());
    }

    public void sortByName() {
        members.sort(Comparator.comparing(FamilyMember::getFullName));
    }

    public void sortByBirthDate() {
        members.sort(Comparator.comparing(FamilyMember::getBirthDate));
    }

    public void sortByAge() {
        members.sort(Comparator.comparingInt(FamilyMember::getAge));
    }

    public void sortByDeathDate() {
        members.sort(Comparator.comparing(FamilyMember::getDeathDate));
    }

    public void sortByGender() {
        members.sort(Comparator.comparing(FamilyMember::getGender));
    }

    public void sortByRelationshipsCount() {
        members.sort(Comparator.comparingInt(person -> person.getRelationships().size()));
    }

    @Override
    public Iterator<FamilyMember> iterator() {
        return members.iterator();
    }
}
