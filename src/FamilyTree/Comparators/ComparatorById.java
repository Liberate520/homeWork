package FamilyTree.Comparators;

import FamilyTreeItems.FamilyTreeItem;

public class ComparatorById<T extends FamilyTreeItem> implements FamilyTreeComparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return (int) o1.getId() - (int) o2.getId();
    }
}
