package HW01.model.auxiliary;

import HW01.model.Basic;

import java.util.Iterator;
import java.util.List;

public class PersonIterator<T extends Basic> implements Iterator<T> {
    private int index;
    private List<T> persons;
    public PersonIterator(List<T> persons) {
        this.persons = persons;
    }
    @Override
    public boolean hasNext() {
        return persons.size()>index;
    }
    @Override
    public T next() {
        return persons.get(index++);
    }
}
