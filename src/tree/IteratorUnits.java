package tree;

import treeUnits.TreeUnit;

import java.util.Iterator;
import java.util.List;

public class IteratorUnits<E extends TreeUnit> implements Iterator<E> {
    private int index;
    private final List<E> listUnits;

    public IteratorUnits(List<E> listUnits) {
        this.listUnits = listUnits;
    }


    @Override
    public boolean hasNext() {
        return index < listUnits.size();
    }

    @Override
    public E next() {
        return listUnits.get(index++);
    }
}
