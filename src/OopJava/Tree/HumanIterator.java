package OopJava.Tree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<E> implements Iterator<E>{
    private List<E> humans;
    private int index;

    public HumanIterator(List<E> human) {
        this.humans = human;
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return index < humans.size();
    }

    @Override
    public E next() {
        // TODO Auto-generated method stub
        return humans.get(index++);
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub
    }
}
