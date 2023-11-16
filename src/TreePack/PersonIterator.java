package TreePack;

import PersonPack.Person;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PersonIterator<E> implements Iterator<E> {
    private HashMap<Integer, E> personList;

    Iterator<Map.Entry<Integer, E>> iterator;
    public PersonIterator(HashMap<Integer, E> personList) {
        this.personList = personList;
        this.iterator = personList.entrySet().iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public E next() {
        return iterator.next().getValue();
    }
}
