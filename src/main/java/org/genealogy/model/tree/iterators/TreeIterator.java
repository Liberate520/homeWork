package org.genealogy.model.tree.iterators;

import java.util.Iterator;
import java.util.List;

public class TreeIterator<E> implements Iterator<E> {
    private int index;
    private List<E> animals;
    public TreeIterator(List<E> animals) {
        this.animals = animals;
    }

    @Override
    public boolean hasNext() {
        return animals.size() > index;
    }

    @Override
    public E next() {
        return animals.get(index++);
    }
}
