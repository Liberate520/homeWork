package family_tree.familytree.iterator;

import family_tree.person.Person;

import java.util.Iterator;
import java.util.List;

public class PersonIterator implements Iterator<Person> {
    private int index;
    private List<Person> allPersons;

    public PersonIterator(List<Person> allPersons) {
        this.allPersons = allPersons;
    }

    @Override
    public boolean hasNext() {
        return index < allPersons.size();
    }

    @Override
    public Person next() {
        return allPersons.get(index++);
    }
}
