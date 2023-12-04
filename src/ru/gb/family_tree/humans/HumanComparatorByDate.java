package ru.gb.family_tree.humans;

import java.util.Comparator;

public class HumanComparatorByDate implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
