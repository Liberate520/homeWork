package family_tree;

import human.Human;
import java.util.Iterator;
import java.util.List;

public class HumanIterator<E> implements Iterator<E> {
    private int index;
    private List<E> list;

    public HumanIterator(List<E> list) {
        this.list = list;
    }
    @Override
    public boolean hasNext() {
        return list.size() > index;
    }
    @Override
    public E next() {
        return list.get(index++);
    }
}
