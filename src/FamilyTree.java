import java.util.ArrayList;
import java.util.List;

class FamilyTree {
    private List<Person> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getAllPeople() {
        return people;
    }
    public void addRelationship(Person person1, Person person2, RelationshipType type) {
        person1.addRelationship(person2, type);
    }

    public List<Relationship> getRelationships(Person person) {
        return person.getRelationships();
    }
    public List<Relationship> getAllRelationships() {
        List<Relationship> allRelationships = new ArrayList<>();
        for (Person person : people) {
            collectRelationships(person, allRelationships);
        }
        return allRelationships;
    }

    private void collectRelationships(Person person, List<Relationship> relationships) {
        relationships.addAll(person.getRelationships());
        for (Person child : person.getChildren()) {
            collectRelationships(child, relationships);
        }
    }
}
