package human.comparators;

import familyTree.FamilyTreeItem;
import human.Human;

import java.util.Comparator;

public class HumanComparatorById<T extends FamilyTreeItem> implements Comparator<T> {


    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getId(),o2.getId());
    }
}
