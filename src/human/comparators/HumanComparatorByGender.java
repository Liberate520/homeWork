package human.comparators;

import familyTree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComparatorByGender<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getGender().compareTo(o2.getGender());
    }
}
