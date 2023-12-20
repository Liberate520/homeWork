package ru.gb.node;

import ru.gb.person.comparators.HumanComparatorByAge;
import ru.gb.person.comparators.HumanComparatorByName;
import ru.gb.person.comparators.HumanIterator;
import ru.gb.person.Person;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FamilyTree implements Serializable, Iterable<Person> {
    private List<Person> humanList;

    public FamilyTree(List<Person> humanList) { this.humanList = humanList; }

    public FamilyTree() { this(new ArrayList<>()); }

    public void add(Person human) {
        if (human == null) { return; }
        if (!humanList.contains(human)) {
            humanList.add(human);

            addToParents(human);
            addToChildren(human);

        }
    }

    private void addToParents(Person human) {
        for (Person parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Person human) {
        for (Person child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public Person getByName(String name) {
        for (Person human : humanList) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Person human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Person> iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge());
    }
}