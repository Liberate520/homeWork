package obj.human.sort;

import familyTree.FamilyTreeItem;

import java.util.Comparator;

public class SortByFirstName<T extends FamilyTreeItem> implements Comparator<T> {
    public int compare(T o1, T o2) { return o1.getFstName().compareTo(o2.getFstName());}
}
