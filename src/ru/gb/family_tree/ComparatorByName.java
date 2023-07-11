package ru.gb.family_tree;

import java.util.Comparator;

public class ComparatorByName<T extends TreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getFullName().compareTo(o2.getFullName());
    }
}
