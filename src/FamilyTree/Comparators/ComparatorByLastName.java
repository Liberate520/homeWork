package FamilyTree.Comparators;

import FamilyTreeItems.FamilyTreeItem;

public class ComparatorByLastName<T extends FamilyTreeItem> implements FamilyTreeComparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
