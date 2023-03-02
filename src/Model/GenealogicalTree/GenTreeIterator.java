package Model.GenealogicalTree;

import java.util.Iterator;
import java.util.List;

public class GenTreeIterator<T extends Animal> implements Iterator<T> {
    private List<T> allListTree;
    private int index;

    public GenTreeIterator(List<T> allListTree) {
        this.allListTree = allListTree;
    }

    @Override
    public boolean hasNext() {
        return index < allListTree.size();
    }

    @Override
    public T next() {
        return allListTree.get(index++);
    }
}
