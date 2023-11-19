package family_Tree.human.comparators;

import family_Tree.familyTree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComparatorByAge<E extends FamilyTreeItem> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getAge().compareTo(o2.getAge());
    }
}
