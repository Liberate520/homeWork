package familyTrees.iterators;

import human.Human;

import java.util.Iterator;
import java.util.List;

public class PersonIterator <T extends Human>implements Iterator<T> {

    private int index;
    private List<T> personList;

    public PersonIterator(List<T> personList) {
        this.personList = personList;
    }

    @Override

    public boolean hasNext() {
        return index < personList.size();
    }

    @Override
    public T next() {
        return personList.get(index++);
    }
}
