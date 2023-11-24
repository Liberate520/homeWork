package model.human.comparators;

import model.familyTree.FamilyTreeItem;

import java.util.Comparator;

public class CompareByAge<E extends FamilyTreeItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
