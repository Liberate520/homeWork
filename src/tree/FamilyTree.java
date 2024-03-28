package tree;

import utils.FamilyTreeIterator;

import java.io.Serializable;
import java.util.*;

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

    public void sortByName() {
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return person1.getName().compareTo(person2.getName());
            }
        });
    }

    public void sortByDateOfBirth() {
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return person1.getBirthYear().compareTo(person2.getBirthYear());
            }
        });
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
