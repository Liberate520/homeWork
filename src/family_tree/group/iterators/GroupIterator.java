package family_tree.group.iterators;

import family_tree.human.Human;

import java.util.List;
import java.util.Iterator;

public class GroupIterator<E> implements Iterator<E> {
    private int index;
    private List<E> listItem;

    public GroupIterator(List<E> listItem) {
        this.listItem = listItem;
    }

    @Override
    public boolean hasNext() {
        return listItem.size() > index;
    }

    @Override
    public E next() {
        return listItem.get(index++);
    }
}
