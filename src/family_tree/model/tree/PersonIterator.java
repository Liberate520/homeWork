package family_tree.model.tree;

import family_tree.model.person.Person;

import java.util.ArrayList;
import java.util.Iterator;

public class PersonIterator<E> implements Iterator<E> {
    private int index;
    ArrayList<E> persons;

    PersonIterator(ArrayList<E> persons) {
        this.persons = persons;
    }

    @Override
    public boolean hasNext() {
        return index < persons.size();
    }

    @Override
    public E next() {
        return persons.get(index++);
    }
}
