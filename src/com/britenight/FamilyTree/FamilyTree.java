package com.britenight.FamilyTree;

import com.britenight.Person.Person;
import com.sun.source.tree.ArrayAccessTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FamilyTree implements Serializable, Iterable {
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

    public List<Relation> getRelations(Person person, boolean isMainPerson) {
        return relations.stream().filter(relation ->
                isMainPerson && relation.getMainPerson().equals(person)
                        || !isMainPerson && relation.getRelationPerson().equals(person)).collect(Collectors.toList());
    }

    public List<Relation> getRelations(Person person, boolean isMainPerson, RelationType searchFor) {
        return relations.stream().filter(relation ->
                (isMainPerson && relation.getMainPerson().equals(person) || !isMainPerson && relation.getRelationPerson().equals(person))
                        && relation.getRelationPersonType() == searchFor).collect(Collectors.toList());
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

    private List<Person> getRelativePeople(List<Relation> relations, boolean isMainPerson) {
        List<Person> list = new ArrayList<>();

        for (Relation i : relations) {
            if (isMainPerson)
                list.add(i.getRelationPerson());
            else
                list.add(i.getMainPerson());
        }

        return list;
    }

    public List<Person> getRelativePeople(Person person, boolean isMainPerson, RelationType searchFor) {
        return getRelativePeople(getRelations(person, isMainPerson, searchFor), isMainPerson);
    }

    public List<Person> getRelativePeople(Person person, boolean isMainPerson) {
        return getRelativePeople(getRelations(person, isMainPerson), isMainPerson);
    }

    public ArrayList<FamilyTreeNode> getNodes() {
        ArrayList<FamilyTreeNode> list = new ArrayList<>();

        for (Person p : people) {
            List<Relation> relations = getRelations(p, true);
            list.add(new FamilyTreeNode(p, relations));
        }

        return list;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            final Iterator nodesIterator = getNodes().iterator();
            @Override
            public boolean hasNext() {
                return nodesIterator.hasNext();
            }

            @Override
            public Object next() {
                return (FamilyTreeNode) nodesIterator.next();
            }
        };
    }

    @Override
    public void forEach(Consumer action) {
        getNodes().forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return getNodes().spliterator();
    }
}
