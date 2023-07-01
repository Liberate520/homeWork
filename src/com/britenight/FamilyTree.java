package com.britenight;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private String name;
    private final List<Person> people;

    public FamilyTree(String name) {
        this.name = name;
        people = new ArrayList<>();
    }

    public void addPerson(Person person)
    {
        people.add(person);
    }

    public void removePerson(Person person)
    {
        people.remove(person);
    }

    public List<Person> getPeople() {
        return people;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
