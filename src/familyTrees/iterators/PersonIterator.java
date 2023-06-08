package familyTrees.iterators;

import members.Human;
import members.Member;

import java.util.Iterator;
import java.util.List;

public class PersonIterator <T extends Member>implements Iterator<T> {

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
