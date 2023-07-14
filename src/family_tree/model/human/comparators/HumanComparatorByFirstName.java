package family_tree.model.human.comparators;

import family_tree.model.family_tree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComparatorByFirstName<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
