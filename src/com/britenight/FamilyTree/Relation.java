package com.britenight.FamilyTree;

import com.britenight.Person.Person;

import java.util.Objects;

public class Relation {
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
    public int hashCode() {
        return Objects.hash(mainPerson, relationPerson, relationPersonType);
    }
}
