package ru.gb.family_tree.model.comparator;

import java.util.Comparator;

public class FamilyTreeComparatorByAge<T extends TreeNode> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getAge() - o2.getAge();
    }
}