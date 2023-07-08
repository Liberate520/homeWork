package faminly_tree.human.comparators;

import faminly_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByBirth implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getBirth().compareTo(o2.getBirth());
    }
}
