package model.human.comparators;

import java.util.Comparator;

import model.familyTree.TreeItem;

public class HumanComparatorByAge<E2 extends TreeItem> implements Comparator<E2> {
    @Override
    public int compare(E2 o1, E2 o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}