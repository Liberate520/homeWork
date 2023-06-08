package Hw.sem1;

import Hw.sem1.Person;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private Person root;
    private List<Person> allMembers;

    public FamilyTree(Person root) {
        this.root = root;
        this.allMembers = new ArrayList<>();
        allMembers.add(root);
    }


    public void addChild(Person parent, Person child) {
        parent.addChild(child);
        allMembers.add(child);
    }


    public List<Person> getAllMembers() {
        return allMembers;
    }
}