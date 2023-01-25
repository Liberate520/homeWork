package Seminars_OOP.HW_6.src.Model;

import java.util.Iterator;
import java.util.List;

class FamilyTreeIterator<T> implements Iterator<T>{
    private int index;
    private List<T> humanList;

    public FamilyTreeIterator(List<T> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public T next() {
        return humanList.get(index++);
    }
}
