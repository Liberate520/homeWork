package org.example.Iterator;

import org.example.Human;

import java.util.ArrayList;
import java.util.Iterator;

public class HumanIterator implements Iterator<Human> {
    private int index;
    private final ArrayList<Human> bigFamily;


    public HumanIterator(ArrayList<Human> bigFamily) {
        this.bigFamily = bigFamily;
    }

    @Override
    public boolean hasNext() {
        return bigFamily.size() > index;
    }

    @Override
    public Human next() {
        return bigFamily.get(index++);
    }
}
