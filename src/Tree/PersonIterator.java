package Tree;

import java.util.Iterator;
import java.util.List;

public class PersonIterator<E> implements Iterator<E> {
    private int index;
    private List<E> familytree;

    public PersonIterator(List<E> familytree){
        this.familytree = familytree;
    }

    @Override
    public boolean hasNext() {
        return index < familytree.size();
    }

    @Override
    public E next() {
        return familytree.get(index++);
    }
}
