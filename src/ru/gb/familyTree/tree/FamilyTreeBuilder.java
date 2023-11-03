package ru.gb.familyTree.tree;

import ru.gb.familyTree.person.Person;

import java.util.ArrayList;
import java.util.List;

public class FamilyTreeBuilder {
    private String family;
    private Person root = null;
    private List<Node<Integer, Person>> nodes = new ArrayList<>();

    public FamilyTreeBuilder setFamily(String family) {
        this.family = family;
        return this;
    }

    public FamilyTreeBuilder setRoot(Person root) {
        this.root = root;
        return this;
    }

    public FamilyTreeBuilder setNode(List<Node<Integer, Person>> nodes) {
        this.nodes = nodes;
        return this;
    }

    public FamilyTree createFamilyTree() {
        return new FamilyTree(family, root, nodes);
    }
}