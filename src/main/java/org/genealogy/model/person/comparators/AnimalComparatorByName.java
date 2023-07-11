package org.genealogy.model.person.comparators;

import org.genealogy.model.tree.TreeItem;
import java.util.Comparator;

public class AnimalComparatorByName<E extends TreeItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
