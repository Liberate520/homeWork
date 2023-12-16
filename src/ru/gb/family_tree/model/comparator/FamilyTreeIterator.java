package ru.gb.family_tree.model.comparator;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T extends TreeNode> implements Iterator<T> {
    private int index;
    private List<T> subList;

    public FamilyTreeIterator(List<T> subList) {
        index = 0;
        this.subList = subList;
    }

    @Override
    public boolean hasNext() {
        return index < subList.size();
    }

    @Override
    public T next() {
        return subList.get(index++);
    }
}
