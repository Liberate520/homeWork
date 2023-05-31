package Hw.sem1;

import Hw.sem1.Person;

import java.util.List;

public class FamilyTree {
    private Person root;

    public FamilyTree(Person root) {
        this.root = root;
    }

    public void addChild(Person parent, Person child) {
        parent.addChild(child);
    }

    public List<Person> getChildren(Person parent) {
        return parent.getChildren();
    }
}