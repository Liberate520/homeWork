package family_tree.model.comparator;

import family_tree.model.tree.TreeNode;

import java.util.Comparator;

public class ComparatorByName<T extends TreeNode<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
