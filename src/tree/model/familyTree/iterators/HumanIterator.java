package tree.model.familyTree.iterators;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T> implements Iterator<T> {
    private int indx;
    private List<T> humanList;

    public HumanIterator(List<T> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return indx < humanList.size();
    }

    @Override
    public T next() {
        return humanList.get(indx++);
    }
}
