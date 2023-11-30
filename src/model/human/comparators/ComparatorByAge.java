package model.human.comparators;

import model.tree.FamilyTreeItem;

import java.util.Comparator;

public class ComparatorByAge<T extends FamilyTreeItem<T> > implements Comparator< T > {


    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
