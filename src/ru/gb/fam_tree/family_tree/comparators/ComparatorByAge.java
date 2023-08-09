package ru.gb.fam_tree.family_tree.comparators;

import ru.gb.fam_tree.family_tree.all_tree_items.FamilyTreeItem;

import java.util.Comparator;

public class ComparatorByAge<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T t1, T t2) {
        return Integer.compare(t1.getDaysOfLife(), t2.getDaysOfLife());
    }
}
