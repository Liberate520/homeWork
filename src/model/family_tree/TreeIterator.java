package model.family_tree;

import java.util.Iterator;
import java.util.List;

public class TreeIterator<T> implements Iterator<T> {
    private List<T> familyTree;
    private int count;

    public TreeIterator(List<T> familyTree) {
        this.familyTree = familyTree;
        this.count = 0;
    }

    @Override
    public boolean hasNext() {
        return count < familyTree.size();
    }

    @Override
    public T next() {
        return familyTree.get(count++);
    }
}
