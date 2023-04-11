package tree;
import java.util.Iterator;
import java.util.List;

public class HumanIterator<E> implements Iterator<E> {
    private int index;
    private final List<E> lst;
    public HumanIterator(List<E> humanList) {
        this.lst = humanList;
    }
    @Override
    public boolean hasNext() {
        return index < lst.size();
    }

    @Override
    public E next() {
        return lst.get(index++);
    }
}
