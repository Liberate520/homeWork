import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Person> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void addRelationship(String parentName, String childName) {
        Person parent = findPerson(parentName);
        Person child = findPerson(childName);

        if (parent != null && child != null) {
            parent.addChild(child);
        } else {
            System.out.println("Person not found in the family tree.");
        }
    }

    public List<Person> getChildrenOfPerson(String name) {
        Person person = findPerson(name);
        if (person != null) {
            return person.getChildren();
        } else {
            System.out.println("Person not found in the family tree.");
            return new ArrayList<>();
        }
    }

    private Person findPerson(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "people=" + people +
                '}';
    }
}
