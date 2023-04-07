package homeWork.person;

import java.util.Iterator;
import java.util.List;

public class PersonIterator implements Iterator<Person> {
    private int index;
    private final List<Person> tree;

    public PersonIterator(List<Person> tree){
        this.tree = tree;
    }
    @Override
    public boolean hasNext() {
        return index < tree.size();
    }

    @Override
    public Person next() {
        return tree.get(index++);
    }
}