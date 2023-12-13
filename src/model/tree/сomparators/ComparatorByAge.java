package model.tree.сomparators;

import java.util.Comparator;
import model.tree.TreeNode;


public class ComparatorByAge<E extends TreeNode> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.age(), o2.age());
    }
}
