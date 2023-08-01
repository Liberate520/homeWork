package FamiliTree;

import java.util.Iterator;
import java.util.List;

public class FamiliTreeIterator<E> implements Iterator<E> {
    private int index;
    private List<E> humansList;

    public FamiliTreeIterator(List<E> humans) {
        this.humansList = humans;
    }

    @Override
    public boolean hasNext() {
        return humansList.size() > index;
    }

    @Override
    public E next() {
        return humansList.get(index++);
    }

}
