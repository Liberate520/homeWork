package ru.gb.family_tree.family_tree.comparator;

import ru.gb.family_tree.family_tree.TreeItem;

import java.util.Comparator;

public class FamilyTreeComparatorByAge<T extends TreeItem<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
