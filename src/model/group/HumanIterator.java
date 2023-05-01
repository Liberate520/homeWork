package model.group;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T> implements Iterator<T> {

    private List<T> group;
    private int index = 0;

    public HumanIterator(List<T> group) {
        this.group=group;
    }

    @Override
    public boolean hasNext() {
        return index < group.size();
    }

    @Override
    public T next() {
        return group.get(index++);
    }
}
