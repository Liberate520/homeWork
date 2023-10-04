package ru.gb.family_tree.Family.ComparatotBy;

import ru.gb.family_tree.Family.Human;
import ru.gb.family_tree.Tree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComparatorByAge<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getAge() - o2.getAge();
    }
}
