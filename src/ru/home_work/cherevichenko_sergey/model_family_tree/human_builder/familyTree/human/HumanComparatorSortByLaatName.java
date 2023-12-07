package ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.human;
import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.FamilyTreeItem;

import java.util.Comparator;
public class HumanComparatorSortByLaatName<E extends FamilyTreeItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
