package Homework.model.Human.Comparators;

import Homework.model.Tree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComporatorByName<E extends FamilyTreeItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
