package ru.gb.Tree.Human.Comparators;

import java.util.Comparator;

import ru.gb.Tree.Human.Human;


public class HumanComparatorByBirthDate implements Comparator<Human>{
    public int compare(Human o1, Human o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}

