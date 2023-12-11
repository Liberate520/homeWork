package ru.gb.family_tree_homework.family_tree;

import java.util.Comparator;

public class TreeComparatorByName<E extends TreeNode<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
