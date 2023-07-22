package com.britenight.FamilyTree;

import com.britenight.Person.Person;

import java.util.List;
import java.util.Objects;

public class FamilyTreeNode implements Comparable {
    private final Person person;
    private final List<Relation> relations;

    public FamilyTreeNode(Person person, List<Relation> relations) {
        this.person = person;
        this.relations = relations;
    }

    public Person getPerson() {
        return person;
    }

    public List<Relation> getRelations() {
        return relations;
    }

    @Override
    public String toString() {
        return String.format("%s | %s - %s, %s", person.getId(), person.getName(), person.getGender(), person.getDateOfBirth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(person.getId(), person.getName(), person.getGender(), person.getDateOfBirth());
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof FamilyTreeNode && this.hashCode() == obj.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        return this.person.compareTo(((FamilyTreeNode) o).getPerson());
    }
}
