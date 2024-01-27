package ru.gb.model.node;

import java.util.Iterator;
import java.util.List;

public class ItemIterator<E extends TreeItem<E>> implements Iterator<E> {
    private int index;
    private List<E> tree;
    public ItemIterator(List<E> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        return index < tree.size();
    }

    @Override
    public E next() {
        return tree.get(index++);
    }
}
