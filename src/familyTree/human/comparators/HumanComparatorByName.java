package familyTree.human.comparators;

import familyTree.familyTree.FamilyGroupItem;
import familyTree.human.Human;

import java.util.Comparator;

public class HumanComparatorByName<T extends FamilyGroupItem>
        implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
