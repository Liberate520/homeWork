package ru.gb.Tree.Human.Comparators;

import java.util.Comparator;

import ru.gb.Tree.Human.Human;

public class HumanComparatorByAge implements Comparator<Human> {
    public int compare(Human o1, Human o2) {
        return Integer.compare(o2.getAge(), o1.getAge());
    }
}
