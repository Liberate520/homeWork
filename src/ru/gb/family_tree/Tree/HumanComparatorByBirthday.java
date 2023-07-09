package ru.gb.family_tree.Tree;

import ru.gb.family_tree.Servise.TreeItem;

import java.util.Comparator;

public class HumanComparatorByBirthday<E extends TreeItem> implements Comparator<E> {


    @Override
    public int compare(E o1, E o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
}
