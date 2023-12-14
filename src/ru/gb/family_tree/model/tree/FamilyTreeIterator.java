package ru.gb.family_tree.model.tree;


import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T extends TreeNode> implements Iterator<T> {
    private int index;
    private List<T> humanList;

    public FamilyTreeIterator(List<T> humanList) {
        index = 0;
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
