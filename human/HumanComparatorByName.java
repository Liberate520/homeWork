package homeWork.human;
import homeWork.family_tree.family_tree.TreeNode;

import java.util.Comparator;

public class HumanComparatorByName<E extends TreeNode> implements Comparator<E>{
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
