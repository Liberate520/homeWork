package ru.gb.family_tree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Person> {
    private List<Person> people;
    private int nextId;

    public FamilyTree() {
        people = new ArrayList<>();
        nextId = 0;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void addPerson(Person person) {
        person.setId(nextId);
        people.add(person);
        nextId++;
    }

    public List<Person> searchByName(String name) {
        List<Person> result = new ArrayList<>();

        for (Person person : people) {
            if (person.getName().equalsIgnoreCase(name)) {
                result.add(person);
            }
        }

        return result;
    }

    public List<Person> searchByAge(int age) {
        List<Person> result = new ArrayList<>();

        for (Person person : people) {
            if (person.calculateAge() == age) {
                result.add(person);
            }
        }

        return result;
    }

    public Iterator<Person> iterator() {
        return people.iterator();
    }
    public Person getPersonById(int id) {
        for (Person person : people) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }
}
