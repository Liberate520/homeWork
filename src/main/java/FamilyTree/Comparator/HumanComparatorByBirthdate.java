package FamilyTree.Comparator;

import FamilyTree.Family.FamilyItem;
import java.util.Comparator;

public class HumanComparatorByBirthdate<T extends FamilyItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthdate().compareTo(o2.getBirthdate());
    }
}
