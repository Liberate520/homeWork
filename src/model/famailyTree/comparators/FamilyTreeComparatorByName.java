package model.famailyTree.comparators;

import java.util.Comparator;

import model.famailyTree.TreeNode;

public class FamilyTreeComparatorByName<T extends TreeNode> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}