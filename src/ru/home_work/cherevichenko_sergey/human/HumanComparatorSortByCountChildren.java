package ru.home_work.cherevichenko_sergey.human;

import ru.home_work.cherevichenko_sergey.human.Human;

import java.util.Comparator;

public class HumanComparatorSortByCountChildren implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getChildren().size() - o2.getChildren().size();
    }
}
