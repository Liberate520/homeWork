package com.britenight.Model.FamilyTree;

import java.util.List;

public class FamilyTreeNode<E extends Comparable<Object>> implements Comparable<Object> {
    private final E object;
    private final List<Relation<E>> relations;

    public FamilyTreeNode(E object, List<Relation<E>> relations) {
        this.object = object;
        this.relations = relations;
    }

    public E getObject() {
        return object;
    }

    public List<Relation<E>> getRelations() {
        return relations;
    }

    @Override
    public String toString() {
        return object.toString();
    }

    @Override
    public int hashCode() {
        return object.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof FamilyTreeNode && this.hashCode() == obj.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        return this.object.compareTo(((FamilyTreeNode<E>) o).getObject());
    }
}
