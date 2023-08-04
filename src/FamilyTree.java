import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Person> people;
    public FamilyTree(){
        this.people = new ArrayList<>();
    }
    public void addPerson(Person person) {
        people.add(person);
    }
    public Person findPersonByName(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }
    public List<Person> getChildrenOfPerson(String name) {
        Person person = findPersonByName(name);
        if (person != null) {
            return person.getChildren();
        }
        return new ArrayList<>();
    }
    public void printFamilyTree(Person person, int level) {
        String indent = "    ".repeat(level);
        System.out.println(indent + person);
        for (Person child : person.getChildren()) {
            printFamilyTree(child, level + 1);
        }
    }
}
