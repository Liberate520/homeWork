package family_tree.model.family_tree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<E> implements Iterator<E> {
    private int index;
    private List<E> items;

    public HumanIterator(List<E> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return index < items.size();
    }

    @Override
    public E next() {
        return items.get(index++);
    }
}
