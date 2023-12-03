package ru.home_work.cherevichenko_sergey.human;



import ru.home_work.cherevichenko_sergey.FamilyTreeItem;

import java.util.Comparator;
public class HumanComparatorSortByCountChildren<E extends FamilyTreeItem> implements  Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getChildren().size() - o2.getChildren().size();
    }
}


