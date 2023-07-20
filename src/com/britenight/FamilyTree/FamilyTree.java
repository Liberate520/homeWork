package com.britenight.FamilyTree;

import com.britenight.Person.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyTree {
    private final ArrayList<Person> people;
    private final ArrayList<Relation> relations;
    public FamilyTree() {
        relations = new ArrayList<>();
        people = new ArrayList<>();
    }

    public void addRelation(Relation relation) {
        relations.add(relation);
    }

    public void removeRelation(Relation relation) {
        relations.remove(relation);
    }

    public List<Relation> getRelations() {
        return relations;
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void removePerson(Person person) {
        var tmp = relations.stream().filter(relation -> relation.getRelationPerson() == person
                || relation.getMainPerson() == person).collect(Collectors.toList());
        for (Relation i : tmp) {
            relations.remove(i);
        }
        people.remove(person);
    }

    public List<Person> getPeople() {
        return people;
    }

    public List<Person> getRelativePeople(Person person, boolean isMainPerson, RelationType searchFor) {
        List<Person> list = new ArrayList<>();
        var tmp = relations.stream().filter(relation ->
                (isMainPerson && relation.getMainPerson() == person || !isMainPerson && relation.getRelationPerson() == person)
                        && relation.getRelationPersonType() == searchFor).collect(Collectors.toList());

        for (Relation i : tmp) {
            if (isMainPerson)
                list.add(i.getRelationPerson());
            else
                list.add(i.getMainPerson());
        }

        return list;
    }
}
