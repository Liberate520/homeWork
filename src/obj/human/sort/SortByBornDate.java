package obj.human.sort;


import familyTree.FamilyTreeItem;

import java.util.Comparator;

public class SortByBornDate<T extends FamilyTreeItem> implements Comparator<T> {
    public int compare(T o1, T o2) { return o1.getBornDate().compareTo(o2.getBornDate());}
}
