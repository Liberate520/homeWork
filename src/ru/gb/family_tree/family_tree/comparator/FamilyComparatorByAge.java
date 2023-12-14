package ru.gb.family_tree.family_tree.comparator;


import ru.gb.family_tree.family_tree.TreeNode;
import ru.gb.family_tree.human.Human;

import java.util.Comparator;

public class FamilyComparatorByAge<A extends TreeNode<A>>implements Comparator<A> {
    @Override
    public int compare(A o1, A o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}