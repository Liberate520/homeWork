package ru.gb.family_tree;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getFullName().compareTo(o2.getFullName());
    }
}
