package java_oop_homeWork.src.kinsman.comparators;

import java_oop_homeWork.src.FamilyTreeItem;
import java_oop_homeWork.src.kinsman.Kinsman;

import java.util.Comparator;

public class KinsmanComparatorByName<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
