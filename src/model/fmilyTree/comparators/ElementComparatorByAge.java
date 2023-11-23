package model.fmilyTree.comparators;

import model.fmilyTree.ItemOfFamilyTree;

import java.util.Comparator;

public class ElementComparatorByAge<E extends ItemOfFamilyTree> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
