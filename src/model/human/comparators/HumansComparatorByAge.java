package model.human.comparators;

import model.familyTree.FamilyTreeItem;

import java.util.Comparator;

public class HumansComparatorByAge<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getAge() - o2.getAge();
    }
}
