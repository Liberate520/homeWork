package Human.Comparators;
import Human.*;

import java.util.Iterator;
import java.util.List;

public class ElementIterator<E> implements Iterator<E> {
    private int index;
    private List<E> elementList;

    public ElementIterator (List<E> elementList) {
        this.elementList = elementList;
    }

    @Override
    public boolean hasNext() {
        return index < elementList.size();
    }

    @Override
    public E next() {
        return elementList.get(index++) ;
    }
}
