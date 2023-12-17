package Family_Tree.model.Tree;

import java.util.Comparator;

public class FamilyTreeComparatorByBirthday <E extends TreeNode> implements Comparator<E>{

    @Override
    public int compare(E o1, E o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
}
