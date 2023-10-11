package Model.familyTree.iterator;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T> implements Iterator<T> {
    private int index;
    private List<T> humanList;

    public FamilyTreeIterator(List<T> humanList) {
        this.humanList = humanList;
    }

    public boolean hasNext() {
        return humanList.size() > index;
    }

    public T next() {
        return humanList.get(index++);
    }
}
