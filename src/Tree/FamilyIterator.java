package Tree;

import java.util.Iterator;
import java.util.List;

public class FamilyIterator<E> implements Iterator<E> {
    private int index;
    private List<E> family;

    public FamilyIterator(List<E> family) {
        this.family = family;
    }

    @Override
    public boolean hasNext() {
        return index < family.size();
    }

    @Override
    public E next() {
        return family.get(index++);
    }
}
