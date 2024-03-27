package utils;

import tree.Person;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Person> {
    private List<Person> people;
    private int index;

    public FamilyTreeIterator(List<Person> people) {
        this.people = people;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < people.size();
    }

    @Override
    public Person next() {
        if (hasNext()) {
            return people.get(index++);
        } else {
            throw new IndexOutOfBoundsException("Больше элементов в итераторе нет.");
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Операция удаления не поддерживается.");
    }
}