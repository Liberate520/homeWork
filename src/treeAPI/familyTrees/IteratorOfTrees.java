package treeAPI.familyTrees;

import java.util.Iterator;
import java.util.List;

public class IteratorOfTrees<E> implements Iterator<E> {
    private int index;
    private List<E> fTrees;

    public IteratorOfTrees(List<E> fTrees) {
        this.fTrees = fTrees;
    }

    @Override
    public boolean hasNext() {
        return index < this.fTrees.size();
    }

    @Override
    public E next() {
        return this.fTrees.get(index++);
    }
}
