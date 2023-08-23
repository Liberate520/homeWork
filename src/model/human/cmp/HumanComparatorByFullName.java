package model.human.cmp;

import model.familyTree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComparatorByFullName<E extends FamilyTreeItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getFullName().compareTo(o2.getFullName());
    }
}
