package ru.gb.family_tree.model.family_tree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T extends TreeItem<T>> implements Iterator<T> {
        private int index;
        private List<T> humanList;

public FamilyTreeIterator(List<T> humanList) {
        this.humanList = humanList;
        }

@Override
public boolean hasNext() {
        return humanList.size() > index;
        }

@Override
public T next() {
        return humanList.get(index++);
        }
}
