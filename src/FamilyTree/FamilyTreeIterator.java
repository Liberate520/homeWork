package src.FamilyTree;

import java.util.ArrayList;
import java.util.Iterator;

public class FamilyTreeIterator<T extends FTObjects> implements Iterator<T> {
    private ArrayList<T> people;
    private int index;

    public FamilyTreeIterator(ArrayList<T> people) {
        this.people = people;
    }

    @Override
    public boolean hasNext() {
        return people.size() > index;
    }

    @Override
    public T next() {
        return people.get(index++);
    }

    @Override
    public void remove() {
    }

}
