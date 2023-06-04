
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class GenealogicalTree implements Serializable {


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
        relationship.getFather().addRelationship(relationship);
        relationship.getMother().addRelationship(relationship);
        relationship.getHusband().addRelationship(relationship);
        relationship.getWife().addRelationship(relationship);
        for (Person child : relationship.getChildren()) {
            child.addRelationship(relationship);
        }
    }

    public List<Person> getAncestors(Person person) {
        List<Person> ancestors = new ArrayList<>();
        findAncestors(person, ancestors);
        return ancestors;
    }

    private void findAncestors(Person person, List<Person> ancestors) {
        for (Relationship relationship : relationships) {
            if (relationship.getChildren().contains(person)) {
                ancestors.add(relationship.getFather());
                ancestors.add(relationship.getMother());
                findAncestors(relationship.getFather(), ancestors);
                findAncestors(relationship.getMother(), ancestors);
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
            if (relationship.getFather() == person || relationship.getMother() == person) {
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

    public List<Relationship> findPersonRelationships(Person person) {
        List<Relationship> personRelationships = new ArrayList<>();

        for (Relationship relationship : relationships) {
            if (relationship.getFather() == person || relationship.getMother() == person || relationship.getChildren().contains(person)) {
                personRelationships.add(relationship);
            }
        }

        return personRelationships;
    }

}




