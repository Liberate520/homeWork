package com.example.FamilyTree.DataForTree;

import java.util.Comparator;

public class ComparatorByName<T extends FamilyInterface> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
