package ru.gb.node;

import ru.gb.person.Person;


import java.util.ArrayList;
import java.util.List;


public class FamilyTree {
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

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Person human : humanList) {
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }
}