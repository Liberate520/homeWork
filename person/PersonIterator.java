package person;

import java.util.Iterator;
import java.util.List;
public class PersonIterator<T> implements Iterator<T> {
    private int index;
    private final List<T> tree;

    public PersonIterator(List<T> tree){
        this.tree = tree;
    }
    @Override
    public boolean hasNext() {
        return index < tree.size();
    }

    @Override
    public T next() {
        return tree.get(index++);
    }
}