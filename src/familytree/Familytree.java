package familytree;

import java.util.ArrayList;
import java.util.List;

public class Familytree {
    private Person rootPerson; //===Начальная точка дерева

    public Familytree(Person rootPerson) {
        this.rootPerson = rootPerson;
    }
    public void addPerson(Person person, Person parent1, Person parent2) {
        person.addParent(parent1);
        person.addParent(parent2);
        parent1.addChild(person);
        parent2.addChild(person);
        //person.addPartner(parent1);
    }

    public List<Person> searchPersonsByName(String name) {
        List<Person> result = new ArrayList<>();
        searchPersonsByNameRecursive(rootPerson, name, result);
        return result;
    }

    private void searchPersonsByNameRecursive(Person currentPerson, String name, List<Person> result) {
        if (currentPerson.getName().equals(name)) {
            result.add(currentPerson);
        }
        for (Person child : currentPerson.getChildren()) {
            searchPersonsByNameRecursive(child, name, result);
        }
    }

    public void printFamilyTree() {
        printFamilyTreeRecursive(rootPerson, 0);
    }

    private void printFamilyTreeRecursive(Person currentPerson, int level) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indent.append("  ");
        }
        System.out.println(indent.toString() + "- " + currentPerson.getName() + " " + currentPerson.getSurname());
        for (Person child : currentPerson.getChildren()) {
            printFamilyTreeRecursive(child, level + 1);
        }
    }
}
