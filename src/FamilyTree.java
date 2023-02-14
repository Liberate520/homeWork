import java.util.List;
import java.util.Map;
import java.util.HashMap;

class FamilyTree {
    private Map<Person, List<Person>> tree;

    public FamilyTree() {
        this.tree = new HashMap<>();
    }

    public void addPerson(Person person) {
        tree.put(person, person.getChildren());
    }

    public void printChildren(Person person) {
        System.out.println("Дети " + person.getFirstName() + " " + person.getSurName() + " " + person.getLastName() + ":");
        for (Person child : tree.get(person)) {
            System.out.println(child.getFirstName());
        }
    }
}
