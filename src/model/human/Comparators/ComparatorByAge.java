package model.human.Comparators;

import java.util.Comparator;

import model.tree.HumanItem;

public class ComparatorByAge<T extends HumanItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getAge().compareTo(o2.getAge());
    }
}