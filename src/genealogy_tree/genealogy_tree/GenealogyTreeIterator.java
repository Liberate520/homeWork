package genealogy_tree.genealogy_tree;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class GenealogyTreeIterator<T> implements Serializable, Iterator<T> {
    private List<T> tree;
    private int currentIndex = 0;

    public GenealogyTreeIterator(List<T> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < tree.size();
    }

    @Override
    public T next() {
        if (hasNext()) {
            return tree.get(currentIndex++);
        } else {
            throw new NoSuchElementException();
        }
    }
}