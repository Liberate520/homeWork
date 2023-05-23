package human.comparators;

import familyTree.FamilyTreeItem;
import human.Human;

import java.util.Comparator;

public class HumanComparatorByLastName<T extends FamilyTreeItem> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
