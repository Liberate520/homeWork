package family_tree.human.comparators;

import family_tree.family_tree.FamilyTreeItem;
import family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByLastName<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
