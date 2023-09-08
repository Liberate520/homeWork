package ru.gb.Tree.Model.Human.Comparators;

import java.util.Comparator;

import ru.gb.Tree.Model.FamilyTree.TreeItem;


public class HumanComparatorByBirthDate <T extends TreeItem> implements Comparator<T>{
    public int compare(T o1, T o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}

