package ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.human;
import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.FamilyTreeItem;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
public class HumansComparatorSortByAge<E extends FamilyTreeItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        int ageo1 = Period.between(o1.getBirthDay(), LocalDate.now()).getYears();
        int ageo2 = Period.between(o2.getBirthDay(),LocalDate.now()).getYears();
        return ageo1 - ageo2;
    }
}
