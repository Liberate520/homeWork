package faminly_tree.model.human.comparators;

import faminly_tree.model.tree.FamiliItem;

import java.util.Comparator;

public class HumanComparatorByAge<T extends FamiliItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}