package ru.gb.family_tree.model.tree;

import java.util.Iterator;
import java.util.List;

public class TreeIterator<T> implements Iterator<T> {
    private int index;
    private List<T> members;

    public TreeIterator(List<T> members) {
        this.members = members;
    }

    @Override
    public boolean hasNext() {
        return members.size() > index;
    }

    @Override
    public T next() {
        return members.get(index++);
    }
}
