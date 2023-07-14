package family_tree.model.human.comparators;

import family_tree.model.family_tree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComparatorByDateBirth<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
