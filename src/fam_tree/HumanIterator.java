package fam_tree;

import java.util.Iterator;
import java.util.List;

class HumanIterator<T> implements Iterator<T> {
    private int index;
    private final List<T> humanList;

    public HumanIterator(List<T> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public T next() {
        return humanList.get(index++);
    }
}
