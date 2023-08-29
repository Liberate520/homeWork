package ru.gb.Tree.Human.Comparators;

import java.util.Comparator;

import ru.gb.Tree.FamilyTree.TreeItem;

public class HumanComparatorByAge<T extends TreeItem> implements Comparator<T> {
    public int compare(T o1, T o2) {
        return Integer.compare(o2.getAge(), o1.getAge());
    }
}
