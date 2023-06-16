package Hw.sem1;

import java.io.Serializable;
import java.util.*;

class FamilyTree implements Serializable, Iterable<Person> {
    private Person root;

    public FamilyTree(Person root) {
        this.root = root;
    }

    public Person getRoot() {
        return root;
    }

    public void setRoot(Person root) {
        this.root = root;
    }

    public void addChild(Person parent, Person child) {
        parent.addChild(child);
        child.setFather(parent);
    }

    public List<Person> getAllMembers() {
        List<Person> allMembers = new ArrayList<>();
        traverseTree(root, allMembers);
        return allMembers;
    }

    private void traverseTree(Person person, List<Person> allMembers) {
        allMembers.add(person);
        for (Person child : person.getChildren()) {
            traverseTree(child, allMembers);
        }
    }

    @Override
    public Iterator<Person> iterator() {
        List<Person> allMembers = getAllMembers();
        return allMembers.iterator();
    }

    public void sortByName() {
        List<Person> allMembers = getAllMembers();
        Collections.sort(allMembers, Comparator.comparing(Person::getName));
    }

    public void sortByBirthDate() {
        List<Person> allMembers = getAllMembers();
        Collections.sort(allMembers, Comparator.comparing(Person::getBirthDate));
    }
}