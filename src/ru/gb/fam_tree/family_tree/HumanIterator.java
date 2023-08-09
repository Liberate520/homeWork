package ru.gb.fam_tree.family_tree;

import ru.gb.fam_tree.family_tree.all_tree_items.FamilyTreeItem;

import java.util.List;

public class HumanIterator<T extends FamilyTreeItem> implements java.util.Iterator<T> {
    private int index;
    private List<T> objectList;

    public HumanIterator(List<T> objectList){
        this.objectList = objectList;
    }

    @Override
    public boolean hasNext() {
        return objectList.size() > index;
    }

    @Override
    public T next() {
        return objectList.get(index++);
    }
}
