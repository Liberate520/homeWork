package model;

import java.util.*;

public class PersonIterator<T extends Person> implements Iterator<T> {
    private int index;
    private List<T>humanList;

    public PersonIterator(List<T> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size() > index;
    }

    @Override
    public T next() {
        return (T) humanList.get(index++);
    }
}