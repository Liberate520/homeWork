package model.human.cmp;

import model.familyTree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComparatorByAge<E extends FamilyTreeItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
