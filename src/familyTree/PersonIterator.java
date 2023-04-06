package familyTree;

import person.Person;

import java.util.Iterator;
import java.util.List;

public class PersonIterator implements Iterator<Person> {
    private int index;
    private List<Person> persons;

    public PersonIterator(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public boolean hasNext() {
        return index < this.persons.size();
    }

    @Override
    public Person next() {
        return this.persons.get(index++);
    }
}