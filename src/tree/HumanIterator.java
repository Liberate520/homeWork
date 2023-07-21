package tree;
import java.util.Iterator;
import java.util.List;

import human.Human;

public class HumanIterator<E extends Human> implements Iterator<E> {
    private int index;
    private List<E> humanList;

    public HumanIterator(List<E> humanL) {
        this.humanList = humanL;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public E next() {
        return humanList.get(index++);
    }
}
