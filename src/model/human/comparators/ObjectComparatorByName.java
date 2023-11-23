package model.human.comparators;

import model.familyTree.FamilyTreeItem;

import java.util.Comparator;

public class ObjectComparatorByName<E extends FamilyTreeItem> implements Comparator<E> {
    public int compare(E o1, E o2){
        return o1.getName().compareTo(o2.getName());
    }
}
