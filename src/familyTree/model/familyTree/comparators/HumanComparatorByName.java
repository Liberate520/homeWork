package familyTree.model.familyTree.comparators;

import familyTree.model.familyTree.FamilyGroupItem;

import java.util.Comparator;

public class HumanComparatorByName<T extends FamilyGroupItem<T>>
        implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
