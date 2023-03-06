package api;

import java.util.Iterator;
import java.util.List;

public class PersonIterator<T extends Person> implements Iterator<T>
{
    private int index;

    private List<T> person;

    public PersonIterator(List<T> person)
    {
        this.person = person;
    }

    @Override
    public boolean hasNext() {
        return person.size() > index;
    }

    @Override
    public T next() {
        return person.get(index++);
    }
}

