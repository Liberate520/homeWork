package tree;

import utils.FamilyTreeIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Person> {

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
            if (parent.getGender().equals(Gender.Male)){
                child.setFather(parent);
            }
            else{
                child.setMother(parent);
            }
        } else {
            System.out.println("tree.Person not found in the family tree.");
        }
    }

    public List<Person> getChildrenOfPerson(String name) {
        Person person = findPerson(name);
        if (person != null) {
            return person.getChildren();
        } else {
            System.out.println("tree.Person not found in the family tree.");
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
        return "tree.FamilyTree{" +
                "people=" + people +
                '}';
    }

    @Override
    public Iterator iterator() {
        return new FamilyTreeIterator(people);
    }
}
