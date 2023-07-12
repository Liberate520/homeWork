package genTree;

import java.util.Iterator;
import java.util.ArrayList;
import interfaces.GenTreeItem;

public class GenTreeIterator<T extends GenTreeItem<T>> implements Iterator<T> {
    private int index = 0;
    private int size;
    private ArrayList<T> items;

    public GenTreeIterator(ArrayList<T> items) {
        this.items = items;
        this.size = items.size();
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    public T next() {
        T item = items.get(index);
        index += 1;
        return item;
    }
}