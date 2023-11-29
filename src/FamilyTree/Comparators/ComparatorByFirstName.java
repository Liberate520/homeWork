package FamilyTree.Comparators;

import FamilyTreeItems.FamilyTreeItem;

public class ComparatorByFirstName<T extends FamilyTreeItem> implements FamilyTreeComparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
