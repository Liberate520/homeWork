package ru.java_oop.family_tree.family_tree;

import ru.java_oop.family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int index;
    private List<Human> humanList;

    public HumanIterator(List<Human> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return this.humanList.size() > index;
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}
