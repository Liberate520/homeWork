package com.example.FamilyTree.DataForTree;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Family> {

    @Override
    public int compare(Family o1, Family o2) {
        return o1.getHuman().getName().compareTo(o2.getHuman().getName());
    }
}
