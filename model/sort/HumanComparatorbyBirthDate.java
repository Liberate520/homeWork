package model.sort;

import java.util.Comparator;

import human.Human;

public class HumanComparatorbyBirthDate implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
