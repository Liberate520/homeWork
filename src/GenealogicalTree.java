
import java.util.ArrayList;
import java.util.List;

class GenealogicalTree {
    private List<Person> people;
    private List<Relationship> relationships;

    public GenealogicalTree() {
        this.people = new ArrayList<>();
        this.relationships = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void addRelationship(Relationship relationship) {
        relationships.add(relationship);
    }

    public List<Person> getAncestors(Person person) {
        List<Person> ancestors = new ArrayList<>();
        findAncestors(person, ancestors);
        return ancestors;
    }

    private void findAncestors(Person person, List<Person> ancestors) {
        for (Relationship relationship : relationships) {
            if (relationship.getChildren().contains(person)) {
                ancestors.add(relationship.getParent());
                findAncestors(relationship.getParent(), ancestors);
                break;
            }
        }
    }

    public List<Person> getDescendants(Person person) {
        List<Person> descendants = new ArrayList<>();
        findDescendants(person, descendants);
        return descendants;
    }

    private void findDescendants(Person person, List<Person> descendants) {
        for (Relationship relationship : relationships) {
            if (relationship.getParent() == person) {
                descendants.addAll(relationship.getChildren());
                for (Person child : relationship.getChildren()) {
                    findDescendants(child, descendants);
                }
            }
        }
    }

    public List<Person> getPeople() {
        return people;
    }
    public void displayAllPeople() {
        System.out.println("All People in the Genealogical Tree:");
        for (Person person : people) {
            System.out.println(person.getName());
        }
    }

}
