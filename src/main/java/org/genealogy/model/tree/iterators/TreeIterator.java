package org.genealogy.model.tree.iterators;

import java.util.Iterator;
import java.util.List;

public class TreeIterator<E> implements Iterator<E> {
    private int index;
    private List<E> people;
    public TreeIterator(List<E> people) {
        this.people = people;
    }

    @Override
    public boolean hasNext() {
        return people.size() > index;
    }

    @Override
    public E next() {
        return people.get(index++);
    }
}
