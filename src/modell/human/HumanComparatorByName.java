package modell.human;

import java.util.Comparator;

import modell.fam_tree.TreeNode;

public class HumanComparatorByName<E extends TreeNode<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
