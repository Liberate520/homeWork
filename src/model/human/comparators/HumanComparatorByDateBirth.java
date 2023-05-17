package java_oop_homeWork.src.model.human.comparators;

import java_oop_homeWork.src.model.FamilyTreeItem;

import java.util.Comparator;

public class HumanComparatorByDateBirth<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getDateBirth().compareTo(o2.getDateBirth());
    }
}
