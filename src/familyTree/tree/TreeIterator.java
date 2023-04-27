package familyTree.tree;

import java.util.Iterator;
import java.util.List;

public class TreeIterator<E> implements Iterator<E> {
    private int index;
    private List<E> tree;

    public TreeIterator(List<E> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext(){
        return index < tree.size();
    }
    @Override
    public E next() {
        return tree.get(index++);
    }
}
