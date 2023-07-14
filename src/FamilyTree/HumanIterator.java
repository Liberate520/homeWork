package FamilyTree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator <E> implements Iterator<E>{
    private List<E> humans;
    private int index;

    public HumanIterator(List<E> human) {
        this.humans = human;
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