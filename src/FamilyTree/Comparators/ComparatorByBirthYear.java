package FamilyTree.Comparators;

import FamilyTreeItems.FamilyTreeItem;

public class ComparatorByBirthYear<T extends FamilyTreeItem> implements FamilyTreeComparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthDate().getYear() - o2.getBirthDate().getYear();
    }
}