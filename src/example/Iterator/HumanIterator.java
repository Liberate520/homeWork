package org.example.Iterator;

import org.example.Human;

import java.util.ArrayList;
import java.util.Iterator;

public class HumanIterator<T extends Human> implements Iterator<T> {
    private int index;
    private final ArrayList<T> bigFamily;


    public HumanIterator(ArrayList<T> bigFamily) {
        this.bigFamily = bigFamily;
    }

    @Override
    public boolean hasNext() {
        return bigFamily.size() > index;
    }

    @Override
    public T next() {
        return bigFamily.get(index++);
    }
}
