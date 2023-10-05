package obj.human.sort;

import familyTree.FamilyTreeItem;

import java.util.Comparator;

public class SortByLastName<T extends FamilyTreeItem> implements Comparator<T> {
    public int compare(T o1, T o2) { return o1.getLstName().compareTo(o2.getLstName());}
}

