package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Relationship implements Serializable {

    private Person father;
    private Person mother;
    private List<Person> children;

    public Relationship(Person father, Person mother) {
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }

    public List<Person> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Person child) {
        children.add(child);
    }
}