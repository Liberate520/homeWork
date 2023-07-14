package faminly_tree.model.human.comparators;

import faminly_tree.model.tree.FamiliItem;

import java.util.Comparator;

public class HumanComparatorByID<E extends FamiliItem<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
