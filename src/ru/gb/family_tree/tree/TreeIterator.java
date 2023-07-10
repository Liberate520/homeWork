package ru.gb.family_tree.tree;

import java.util.Iterator;
import java.util.List;

public class TreeIterator<T> implements Iterator<T> {
    private int index;
    private List<T> tList;

    public TreeIterator(List<T> tList) {
        this.tList = tList;
    }

    @Override
    public boolean hasNext() {
        return tList.size() > index;
    }

    @Override
    public T next() {
        return tList.get(index++);
    }
}
