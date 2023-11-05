package ru.gb.familyTree.tree;

import ru.gb.familyTree.person.Person;

import java.util.HashSet;

public class NodeBuilder <E1, E2>{
    private E1 id;
    private FamilyTree family;
    private E2 parentOne;
    private E2 parentTwo;
    private HashSet<E2> children = new HashSet<>();

    public NodeBuilder<E1,E2> setId(E1 id) {
        this.id = id;
        return this;
    }

    public NodeBuilder<E1,E2> setFamily(FamilyTree family) {
        this.family = family;
        return this;
    }

    public NodeBuilder<E1,E2> setParentOne(E2 parentOne) {
        this.parentOne = parentOne;
        return this;
    }

    public NodeBuilder<E1,E2> setParentTwo(E2 parentTwo) {
        this.parentTwo = parentTwo;
        return this;
    }

    public NodeBuilder<E1,E2> setChildren(HashSet<E2> children) {
        this.children = children;
        return this;
    }

    public Node<E1, E2> createNode() {
        return new Node<E1, E2>(id, family, parentOne, parentTwo, children);
    }
}