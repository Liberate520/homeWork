package model.tree;

import model.person.Person;

import java.util.Iterator;
import java.util.List;

public class TreeIterator<T> implements Iterator<T> {
    private int index;
    private List<T> personList;

    public TreeIterator(List<T> personList) {
        this.personList = personList;
    }

    @Override
    public boolean hasNext() {
        return index < personList.size();
    }

    @Override
    public T next() {
        return personList.get(index++);
    }
}