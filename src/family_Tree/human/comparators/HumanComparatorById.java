package family_Tree.human.comparators;

import family_Tree.familyTree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComparatorById<E extends FamilyTreeItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
