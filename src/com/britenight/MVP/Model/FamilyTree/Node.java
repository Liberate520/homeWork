package com.britenight.MVP.Model.FamilyTree;

import com.britenight.MVP.Model.Relation.Relation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Node<E extends Comparable<E>> implements Serializable, Comparable<Node<E>> {
    private final E mainObject;
    private final ArrayList<Relation<E>> relations;


    public Node(E mainObject, ArrayList<Relation<E>> relations) {
        this.mainObject = mainObject;
        this.relations = relations;
    }


    //region Getters

    public E getMainObject() {
        return mainObject;
    }

    public ArrayList<Relation<E>> getRelations() {
        return relations;
    }

    //endregion

    //region DefaultOverride

    @Override
    public int compareTo(Node<E> o) {
        return this.mainObject.compareTo(o.getMainObject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainObject);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Node && this.hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(mainObject + "\nHas relations:");

        for (Relation<E> r : relations) {
            result.append("\n");
            result.append(r);
        }
        if (relations.size() == 0) {
            result.append("\n");
            result.append("None");
        }

        return result.toString();
    }
    //endregion
}
