package model.familyTree;

import java.util.Iterator;
import java.util.List;


public class FamilyTreeIterator<T> implements Iterator<T> {
    private int index;
    private List<T> humans;

    public FamilyTreeIterator(List<T> humans) {
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {
        return humans.size() > index;
    }

    @Override
    public T next() {
        return humans.get(index++);
    }

}
