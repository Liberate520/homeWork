package com.example.FamilyTree.DataForTree;

import java.util.Comparator;

public class ComparatorByBirthday<T extends FamilyInterface> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
}
