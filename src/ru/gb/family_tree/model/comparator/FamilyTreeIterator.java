package ru.gb.family_tree.model.comparator;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T> implements Iterator<T> {
    private int index;
    private List<T> familyTreeList;

    public FamilyTreeIterator(List<T> familyTreeList) {
        index = 0;
        this.familyTreeList = familyTreeList;
    }

    @Override
    public boolean hasNext() {
        return index < familyTreeList.size();
    }

    @Override
    public T next() {
        return familyTreeList.get(index++);
    }
}
