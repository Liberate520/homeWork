package familyTree.model.comporator;

import java.util.Iterator;
import java.util.List;

import familyTree.model.Animal;

public class AnimalIterator<T extends Animal> implements Iterator<T> {
    private int index;
    private List<T> humans;

    public AnimalIterator(List<T> humans) {
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
