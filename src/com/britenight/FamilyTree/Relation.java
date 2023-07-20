package com.britenight.FamilyTree;

import com.britenight.Person.Person;

import java.io.Serializable;
import java.util.Objects;

public class Relation implements Serializable {
    private final Person mainPerson;
    private final Person relationPerson;
    private final RelationType relationPersonType;

    public Relation(Person mainPerson, Person relationPerson, RelationType relationPersonType) {
        this.mainPerson = mainPerson;
        this.relationPerson = relationPerson;
        this.relationPersonType = relationPersonType;
    }

    public Person getMainPerson() {
        return mainPerson;
    }

    public Person getRelationPerson() {
        return relationPerson;
    }

    public RelationType getRelationPersonType() {
        return relationPersonType;
    }

    @Override
    public String toString() {
        return String.format("%s has %s as %s", mainPerson, relationPerson, relationPersonType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainPerson, relationPerson, relationPersonType);
    }
}
