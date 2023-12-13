package model.tree.сomparators;

import java.util.Comparator;
import model.tree.TreeNode;

public class ComparatorByName<E extends TreeNode> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
