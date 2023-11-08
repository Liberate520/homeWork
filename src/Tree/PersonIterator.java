package Tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PersonIterator implements Iterator<Person> {
    private HashMap<Integer, Person> personList;

    Iterator<Map.Entry<Integer, Person>> iterator;
    public PersonIterator(HashMap<Integer, Person> personList) {
        this.personList = personList;
        this.iterator = personList.entrySet().iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Person next() {
        return iterator.next().getValue();
    }
}
