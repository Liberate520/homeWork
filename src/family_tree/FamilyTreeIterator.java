package family_tree;

import human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<E> implements Iterator<E> {
    private int index = 0;
    private List<E> list;

    public FamilyTreeIterator(List<E> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public E next() {
        return list.get(index++);
    }
}
