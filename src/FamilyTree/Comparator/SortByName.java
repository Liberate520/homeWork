package FamilyTree.Comparator;

import java.util.Comparator;

import FamilyTree.FamilyTree.EntityItem;


public class SortByName<E extends EntityItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
