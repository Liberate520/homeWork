package ru.gb.family_tree_homework.human;

import java.util.Comparator;

public class HumanComparatorByAge implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAge().compareTo(o2.getAge());
    }
}
