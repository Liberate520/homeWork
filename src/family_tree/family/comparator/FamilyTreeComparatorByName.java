package family_tree.family.comparator;

import family_tree.family.TreeNode;

import java.util.Comparator;

public class FamilyTreeComparatorByName<T extends TreeNode<T>> implements Comparator<T> {


    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
