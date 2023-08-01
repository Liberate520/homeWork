package ru.gb.model.human;

import ru.gb.model.family_tree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComparatorByAge<T extends FamilyTreeItem<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Long.compare((int) o1.getAge(), o2.getAge());
    }
}
