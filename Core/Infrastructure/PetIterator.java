package homeWork3.Core.Infrastructure;

import homeWork3.Core.Models.PetFamily;

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
