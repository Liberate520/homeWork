package com.example.FamilyTree.DataForTree;

import java.util.Comparator;

public class HumanComparatorByName implements Comparator<HumanFamily> {

    @Override
    public int compare(HumanFamily o1, HumanFamily o2) {
        return o1.getHuman().getName().compareTo(o2.getHuman().getName());
    }
}
