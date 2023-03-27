package seer;

import java.util.ArrayList;

public class FamilyTree {
    private Person pers;

    public FamilyTree(Person pers) {
        this.pers = pers;
    }

    public Person getPers() {
        return pers;
    }

    public ArrayList<Person> getChildren(Person person) {
        return person.getChildren();
    }

    public ArrayList<Person> getAllChildren(Person person) {
        return person.getAllChildren();
    }
}
