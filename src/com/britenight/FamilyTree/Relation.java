package com.britenight.FamilyTree;

import com.britenight.Person.Person;

import java.io.Serializable;
import java.util.Objects;

public class Relation<E> implements Serializable {
    private final E mainObject;
    private final E relationObject;
    private final RelationType relationObjectType;

    public Relation(E mainObject, E relationObject, RelationType relationObjectType) {
        this.mainObject = mainObject;
        this.relationObject = relationObject;
        this.relationObjectType = relationObjectType;
    }

    public E getMainObject() {
        return mainObject;
    }

    public E getRelationObject() {
        return relationObject;
    }

    public RelationType getRelationObjectType() {
        return relationObjectType;
    }

    @Override
    public String toString() {
        return String.format("%s has %s as %s", mainObject, relationObject, relationObjectType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainObject, relationObject, relationObjectType);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Relation && this.hashCode() == obj.hashCode();
    }
}
