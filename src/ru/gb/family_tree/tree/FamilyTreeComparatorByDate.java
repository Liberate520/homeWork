package ru.gb.family_tree.tree;


import java.util.Comparator;

public class FamilyTreeComparatorByDate<T extends TreeNode> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getDeathDate().compareTo(o2.getDeathDate());
    }
}
