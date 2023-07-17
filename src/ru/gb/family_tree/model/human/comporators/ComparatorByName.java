package ru.gb.family_tree.model.human.comporators;

import ru.gb.family_tree.model.tree.TreeItem;

import java.util.Comparator;

public class ComparatorByName<T extends TreeItem<TreeItem>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getFullName().compareTo(o2.getFullName());
    }
}
