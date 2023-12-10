package family_tree.model.family.comparator;

import family_tree.model.family.TreeNode;

import java.util.Comparator;

public class FamilyTreeComparatorByAge<T extends TreeNode<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
