package tree;

import person.Person;

import java.util.Iterator;
import java.util.List;

public class TreeIterator implements Iterator<Person> {
    private int index;
    private List<Person> tree;

    public TreeIterator(List<Person> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext(){
        return index < tree.size();
    }
    @Override
    public Person next() {
        return tree.get(index++);
    }
}
