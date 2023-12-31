package ru.gb.treeItem.comparators;

import ru.gb.node.TreeItem;

import java.util.Comparator;

public class ItemComparatorByAge<E extends TreeItem<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
