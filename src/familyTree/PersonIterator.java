package familyTree;

import member.Member;

import java.util.Iterator;
import java.util.List;

public class PersonIterator<E extends Member> implements Iterator<E> {
    private int index;
    private List<E> persons;

    public PersonIterator(List<E> persons) {
        this.persons = persons;
    }

    @Override
    public boolean hasNext() {
        return index < this.persons.size();
    }

    @Override
    public E next() {
        return this.persons.get(index++);
    }
}