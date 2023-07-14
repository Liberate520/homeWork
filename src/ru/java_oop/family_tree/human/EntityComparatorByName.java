package ru.java_oop.family_tree.human;

import ru.java_oop.family_tree.family_tree.FamilyTreeItem;

import java.util.Comparator;

public class EntityComparatorByName<T extends FamilyTreeItem> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
