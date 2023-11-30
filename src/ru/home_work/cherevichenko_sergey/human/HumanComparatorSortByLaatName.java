package ru.home_work.cherevichenko_sergey.human;

import ru.home_work.cherevichenko_sergey.human.Human;

import java.util.Comparator;

public class HumanComparatorSortByLaatName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
