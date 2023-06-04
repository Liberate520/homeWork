package com.example.FamilyTree.DataForTree;

import java.util.Comparator;

public class HumanComparatorByBirthday implements Comparator<HumanFamily> {

    @Override
    public int compare(HumanFamily o1, HumanFamily o2) {
        return o1.getHuman().getBirthday().compareTo(o2.getHuman().getBirthday());
    }
}
