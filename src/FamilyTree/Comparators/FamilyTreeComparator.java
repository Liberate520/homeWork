package FamilyTree.Comparators;

import java.util.Comparator;

public interface FamilyTreeComparator<T> extends Comparator<T> {
    public int compare(T o1, T o2);
}