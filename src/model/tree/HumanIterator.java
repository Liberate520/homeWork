package model.tree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T> implements Iterator< T > {
    private int index;
    private List<T> FamilyList;

    public HumanIterator(List<T> FamilyList) {
        this.FamilyList = FamilyList;
    }
    @Override
    public boolean hasNext() {
        return index<FamilyList.size();
    }

    @Override
    public T next() {
        return FamilyList.get(index++);
    }
}
