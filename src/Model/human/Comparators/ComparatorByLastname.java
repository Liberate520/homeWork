package Model.human.Comparators;

import Model.tree.FamilyTreeItem;

import java.util.Comparator;

public class ComparatorByLastname<T extends FamilyTreeItem<T> > implements Comparator< T > {
    @Override
    public int compare(T o1, T o2) {
        return o1.getLastname().compareTo(o2.getLastname());
    }
}
