package homeWork3.comparator;

import homeWork3.model.PetFamily;

import java.util.List;

public class PetIterator<T extends PetFamily> implements java.util.Iterator<T> {
    private int index;
    private List<T> humans;

    public PetIterator(List<T> humans) {
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
