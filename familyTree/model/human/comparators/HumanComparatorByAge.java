package familyTree.model.human.comparators;

import familyTree.model.group.GroupItem;

import java.util.Comparator;

public class HumanComparatorByAge<T extends GroupItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
