package com.romanovcopy.gmail_Genealogy;

import java.util.HashMap;
import java.util.Map;

public class GenealogyGraph {

    private Map<String, Person> people;

    public GenealogyGraph() {
        this.people = new HashMap<>();
    }

    public void addPerson(String name) {
        Person person = new Person(name);
        people.put(name, person);
    }

    public void addParentChildRelationship(String parentName, String childName) {
        Person parent = people.get(parentName);
        Person child = people.get(childName);

        if (parent != null && child != null) {
            parent.addChild(child);
            child.addParent(parent);
        }
    }

    public List<Person> getParents(String name) {
        Person person = people.get(name);
        if (person != null) {
            return person.getParents();
        }
        return Collections.emptyList();
    }

    public List<Person> getChildren(String name) {
        Person person = people.get(name);
        if (person != null) {
            return person.getChildren();
        }
        return Collections.emptyList();
    }

}
