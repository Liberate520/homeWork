package family_tree.human.comporators;

import family_tree.family_tree.TreeNode;
import family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByAge <E extends TreeNode> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
