package ru.gb.family_tree.model.tree;

import java.util.Comparator;

public class ComparatorByName<T extends Memberable> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) { return o1.name().compareTo(o2.name()); }
}
