package model.humans.comparators;

import model.famalyTree.FamilyTreeItems;

import java.util.Comparator;

public class ComparatorByChildren<T extends FamilyTreeItems> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        int a = o1.getChildrenName().split(", ").length;
        int b = o2.getChildrenName().split(", ").length;
        if (o1.getChildrenName().equals("нет детей")) {a = 0;}
        if (o2.getChildrenName().equals("нет детей")) {b = 0;}
        return Integer.compare(a, b);
    }
}