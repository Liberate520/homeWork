package family_tree.familytree.iterator;

import family_tree.person.Person;

import java.util.Iterator;
import java.util.List;

public class PersonIterator<E> implements Iterator<E> {
    private int index;
    private List<E> allPersons;

    public PersonIterator(List<E> allPersons) {
        this.allPersons = allPersons;
    }

    @Override
    public boolean hasNext() {
        return index < allPersons.size();
    }

    @Override
    public E next() {
        return allPersons.get(index++);
    }
}
