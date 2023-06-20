package model.tree.comparators;

import model.GroupItem;

import java.util.Comparator;

public class TreeComparatorByName<T extends GroupItem> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
