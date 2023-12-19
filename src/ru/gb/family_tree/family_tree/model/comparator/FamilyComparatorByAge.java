package ru.gb.family_tree.family_tree.model.comparator;


import ru.gb.family_tree.family_tree.model.TreeNode;

import java.util.Comparator;

public class FamilyComparatorByAge<A extends TreeNode<A>>implements Comparator<A> {
    @Override
    public int compare(A o1, A o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}