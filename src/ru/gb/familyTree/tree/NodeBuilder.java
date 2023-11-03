package ru.gb.familyTree.tree;

import ru.gb.familyTree.person.Person;

import java.util.HashSet;

public class NodeBuilder {
    private int id;
    private FamilyTree family;
    private Person parentOne;
    private Person parentTwo;
    private HashSet<Person> children = new HashSet<>();

    public NodeBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public NodeBuilder setFamily(FamilyTree family) {
        this.family = family;
        return this;
    }

    public NodeBuilder setParentOne(Person parentOne) {
        this.parentOne = parentOne;
        return this;
    }

    public NodeBuilder setParentTwo(Person parentTwo) {
        this.parentTwo = parentTwo;
        return this;
    }

    public NodeBuilder setChildren(HashSet<Person> children) {
        this.children = children;
        return this;
    }

    public Node<Integer, Person> createNode() {
        return new Node<Integer, Person>(id, family, parentOne, parentTwo, children);
    }
}