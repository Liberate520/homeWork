package ru.java_oop.family_tree.model.family_tree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T extends FamilyTreeItem> implements Iterator<T> {
    private int index;
    private List<T> humanList;

    public HumanIterator(List<T> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return this.humanList.size() > index;
    }

    @Override
    public T next() {
        return humanList.get(index++);
    }
}
