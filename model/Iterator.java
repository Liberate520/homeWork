package homeWork3.model;

import java.util.List;

public class Iterator<T extends MainFamily> implements java.util.Iterator<T> {
    private int index;
    private List<T> humans;

    public Iterator(List<T> humans) {
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {
        return humans.size() > index;
    }

    @Override
    public T next() {
        return humans.get(index++);
    }
}
