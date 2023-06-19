package model.human.comparators;

import model.family_tree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComparatorByLastName<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T h1, T h2) {
        return h1.getLastName().compareTo(h2.getLastName());
    }
}