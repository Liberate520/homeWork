package model.person;

import java.util.*;

public class PersonIterator<E> implements Iterator<E> {
    private int index;
    private List<E> humanList = new ArrayList<>();

    public PersonIterator(HashMap<Integer, E> humanMap) {
        this.humanList.addAll(humanMap.values());
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public E next() {
        return humanList.get(index++);
    }
}
