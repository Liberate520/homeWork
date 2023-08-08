package FamilyTree.Tree.model.Comparators;


import FamilyTree.Tree.model.HumanGroup.HumanGroupItem;

import java.util.Comparator;

public class HumanComparatorByName <E extends HumanGroupItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
