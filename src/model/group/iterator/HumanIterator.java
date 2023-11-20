package model.group.iterator;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<E> implements Iterator<E> {
    private int index;
    private List<E> humanList;

    public HumanIterator(List<E> humanList) {
        this.humanList = humanList;
    }

    public boolean hasNext() {
        return index < humanList.size();
    }

    public E next() {
        return humanList.get(index++);
    }
}
