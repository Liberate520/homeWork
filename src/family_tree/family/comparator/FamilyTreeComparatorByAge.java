package family_tree.family.comparator;

import family_tree.family.TreeNode;

import java.util.Comparator;

public class FamilyTreeComparatorByAge<T extends TreeNode<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
