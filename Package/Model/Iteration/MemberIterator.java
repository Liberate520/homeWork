package Package.Model.Iteration;

import Package.Model.Tree.Person;

import java.util.Iterator;
import java.util.List;

public class MemberIterator<E extends Person> implements Iterator<E> {
    private int index;
    private List<E> family;

    public MemberIterator(List<E> family) {
        this.family = family;
    }

    @Override
    public boolean hasNext() {
        return index < family.size();
    }

    @Override
    public E next() {
        return family.get(index++);
    }
}
