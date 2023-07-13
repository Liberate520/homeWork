package family_tree.tree;

import family_tree.person.Person;

import java.util.ArrayList;
import java.util.Iterator;

public class PersonIterator implements Iterator<Person> {
    private int index;
    ArrayList<Person> persons;

    PersonIterator(ArrayList<Person> persons) {
        this.persons = persons;
    }

    @Override
    public boolean hasNext() {
        return index < persons.size();
    }

    @Override
    public Person next() {
        return persons.get(index++);
    }
}
