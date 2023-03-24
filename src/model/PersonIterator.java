package model;

import java.util.ArrayList;
import java.util.Iterator;

public class PersonIterator<T extends Person> implements Iterator<T> {
    private int index;
    private ArrayList<T> Ancestry;

    public PersonIterator(ArrayList<T> Ancestry) {
        this.Ancestry = Ancestry;
    }

    @Override
    public boolean hasNext() {
        return Ancestry.size() > index;
    }

    @Override
    public T next() {
        return Ancestry.get(index++);
    }
}
