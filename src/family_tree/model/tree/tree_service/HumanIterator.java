package family_tree.model.tree.tree_service;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<E> implements Iterator<E> {
    private int index;
    private final List<E> humanList;

    public HumanIterator(List<E> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size() > index;
    }

    @Override
    public E next() {
        return humanList.get(index++);
    }
}
