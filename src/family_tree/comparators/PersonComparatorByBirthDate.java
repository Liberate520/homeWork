package family_tree.comparators;

import family_tree.FamilyTreeItem;

import java.util.Comparator;

public class PersonComparatorByBirthDate<T extends FamilyTreeItem> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getBirthDate().getYear(), o2.getBirthDate().getYear());
    }

}
