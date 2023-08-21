package model;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FamilyIterator<T> implements Iterator<T> {
    private List<T> familyList;
    private int index;

    public FamilyIterator(List<T> familyList) {
        this.familyList = familyList;
    }

    @Override
    public boolean hasNext() {
        return familyList.size() > index;
    }

    @Override
    public T next () {
        return familyList.get(index++);
    }
}
