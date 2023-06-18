package FamilyTree.model.familyTree;

import java.util.Comparator;

public class AgeComparator<T extends TreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getDeathDate().compareTo(o2.getDeathDate());
    }
}
