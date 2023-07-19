package model.familyTree;

import java.util.Comparator;

public class FamilyTreeComparatorByName<T extends TreeNode> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}