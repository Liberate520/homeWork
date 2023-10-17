package ru.gb.familyTree.tree;

import ru.gb.familyTree.person.Person;

import java.util.HashSet;

public class FamilyTreeBuilder {
    private String family;
    private Person root = null;
    private HashSet<Node> nodes;

    public FamilyTreeBuilder setFamily(String family) {
        this.family = family;
        return this;
    }

    public FamilyTreeBuilder setRoot(Person root) {
        this.root = root;
        return this;
    }

    public FamilyTreeBuilder setNode(HashSet<Node> nodes) {
        this.nodes = nodes;
        return this;
    }

    public FamilyTree createFamilyTree() {
        return new FamilyTree(family, root, nodes);
    }
}