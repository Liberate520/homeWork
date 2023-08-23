package familytree;

import java.util.*;

public class FamilyTree {
    private final List<Person> people;
    public FamilyTree(){
        this.people = new ArrayList<>();
    }
    public void addPerson(Person person) {
        people.add(person);
    }
    public List<Person> getPeople() {
        return people;
    }

    public Iterator<Person> iterator() {
        return people.iterator();
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

    public void sortByName(){
        people.sort(Comparator.comparing(Person::getName));
    }

    public void sortByDateOfBirth(){
        people.sort(Comparator.comparing(Person::getDayOfBirth));
    }
}
