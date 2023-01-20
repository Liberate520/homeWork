package tree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T extends Creature> implements Iterator<T> {
    private int index;
    private List<T> treeElements;

    public FamilyTreeIterator(List<T> treeElements) {
        this.treeElements = treeElements;
    }

    @Override
    public boolean hasNext() {
        return index < treeElements.size();
    }

    @Override
    public T next() {
        return treeElements.get(index++);
    }
}
