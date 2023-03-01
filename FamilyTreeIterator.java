package main;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T> implements Iterator<T> {

    private List<T> members;
    private int index;

    public FamilyTreeIterator(List<T> members) {
        this.members = members;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean hasNext() {
        return index < members.size();
    }

    @Override
    public T next() {
        return members.get(index++);
    }
}