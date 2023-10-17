package ru.gb.familyTree.tree;

import ru.gb.familyTree.exceptions.TreeExceptions;
import ru.gb.familyTree.person.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FamilyTree {
    private String family;
    private Person root;
    private HashSet<Node> nodes;

    public FamilyTree(String family, Person root, HashSet<Node> nodes) {
        this.setFamily(family);
        this.setRoot(root);
        this.setNode(nodes);
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setRoot(Person root) {
        this.root = root;
    }

    public void setNode(HashSet<Node> nodes) {
        this.nodes = nodes;
    }

    public String getFamily() {
        return family;
    }

    public Person getRoot() {
        return root;
    }

    public HashSet<Node> getNode() {
        return nodes;
    }
}