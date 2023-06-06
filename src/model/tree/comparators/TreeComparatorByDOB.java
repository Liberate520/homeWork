package model.tree.comparators;

import model.GroupItem;
import model.person.Person;

import java.util.Comparator;

import java.util.Comparator;

public class TreeComparatorByDOB<T extends GroupItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}
