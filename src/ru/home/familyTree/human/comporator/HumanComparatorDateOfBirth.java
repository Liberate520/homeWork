package ru.home.familyTree.human.comporator;

import ru.home.familyTree.family_Tree.TreeItem;

import java.util.Comparator;

public class HumanComparatorDateOfBirth<E extends TreeItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2){
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
