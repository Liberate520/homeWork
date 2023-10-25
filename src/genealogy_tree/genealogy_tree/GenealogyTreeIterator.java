package genealogy_tree.genealogy_tree;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class GenealogyTreeIterator<T> implements Serializable, Iterator<T> {
    private List<T> people;
    private int currentIndex = 0;

    public GenealogyTreeIterator(List<T> people) {
        this.people = people;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < people.size();
    }

    @Override
    public T next() {
        if (hasNext()) {
            return people.get(currentIndex++);
        } else {
            throw new NoSuchElementException();
        }
    }
}