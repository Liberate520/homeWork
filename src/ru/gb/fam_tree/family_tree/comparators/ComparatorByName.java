package ru.gb.fam_tree.family_tree.comparators;

import ru.gb.fam_tree.family_tree.all_tree_items.FamilyTreeItem;

import java.util.Comparator;

public class ComparatorByName<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T t1, T t2){
        return t1.getName().compareTo(t2.getName());
    }
}
