package familystructure;

import java.util.Iterator;
import java.util.List;

public class FamilyIterator<E> implements Iterator<E> {
    private int index;
    private List<E> humans;

    public FamilyIterator(List<E> humans) {
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {
        return index < humans.size();
    }

    @Override
    public E next() {
        return humans.get(index++);
    }
}
