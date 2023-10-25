package genealogy_tree.genealogy_tree;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import genealogy_tree.person.Person;

public class GenealogyTreeIterator implements Serializable, Iterator<Person> {
    private List<Person> people;
    private int currentIndex = 0;

    public GenealogyTreeIterator(List<Person> people) {
        this.people = people;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < people.size();
    }

    @Override
    public Person next() {
        if (hasNext()) {
            return people.get(currentIndex++);
        } else {
            throw new NoSuchElementException();
        }
    }
}