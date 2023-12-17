package ru.gb.family_tree.human;

import ru.gb.family_tree.family_tree.TreeNode;
import ru.gb.family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByName<T extends TreeNode> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
