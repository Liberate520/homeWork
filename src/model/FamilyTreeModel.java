package model;

import model.human.Person;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FamilyTreeModel implements Serializable {
    private List<Person> people;

    public FamilyTreeModel()
    {
        this.people = new ArrayList<>();
    }

    public List<Person> getPeople() {
        return people;
    }

    public void addPerson(Person person)
    {
        people.add(person);
    }

    public void findPerson(String name, String lastName) {
        for (Person p : people) {
            if (p.getName().equals(name) && p.getLastName().equals(lastName)) {
                System.out.println("Найден человек:\n" + "\t" + p);
            }
        }
        System.out.println();
    }

    public void showTree() {
        for (Person p : people){
            System.out.println(p.toString());
        }
        System.out.println();
    }

    public void sortByName() {
        people.sort(Comparator.comparing(Person::getName));
    }

    public void sortByBirthDate() {
        people.sort(Comparator.comparing(Person::getDateOfBirth));
    }
}
