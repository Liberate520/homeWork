import java.util.List;
import java.util.stream.Collectors;

public class FamilyTree {
    private List<Person> people;

    public FamilyTree(List<Person> people) {
        this.people = people;
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getAllPeople() {
        return people;
    }

    public void addRelationship(Person person1, Person person2, RelationshipType type) {
        person1.addRelationship(new Relationship(person1, person2, type));
    }

    public List<Relationship> getRelationships(Person person) {
        return person.getRelationships();
    }

    public List<Relationship> getAllRelationships() {
        return people.stream()
                .flatMap(person -> person.getRelationships().stream())
                .collect(Collectors.toList());
    }
}

