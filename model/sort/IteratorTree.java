package model.sort;

import java.util.List;

import java.util.Iterator;

public class IteratorTree<E> implements Iterator<E> {
    private List<E> humansList;
    private int index;

    public IteratorTree(List<E> humanList) {
        this.humansList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index < humansList.size();
    }

    @Override
    public E next() {
        return humansList.get(index++);
    }

}
