package ru.gb.family_tree.model.human;

import ru.gb.family_tree.model.family_tree.TreeNode;

import java.util.Comparator;

public class HumanComparatorByBirthDate<E extends TreeNode> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
