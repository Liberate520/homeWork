package Model.obj.human.sort;

import Model.familyTree.FamilyTreeItem;

import java.util.Comparator;

public class SortByAge<T extends FamilyTreeItem> implements Comparator<T> {
    public int compare(T o1, T o2) { return Integer.compare(o1.getAge(), o2.getAge());}
}
