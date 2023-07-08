package faminly_tree.tree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<E extends FamiliItem> implements Iterator{
    private List<E> list;
    private int index;

    public HumanIterator(List<E> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return list.size() > index;
    }

    @Override
    public E next() {
        return list.get(index++);
    }
}
