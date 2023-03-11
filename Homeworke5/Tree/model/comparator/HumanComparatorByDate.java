package model.comparator;

import java.util.Comparator;

import model.Human;

public class HumanComparatorByDate implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getYearOfBirth(), o2.getYearOfBirth()); }
}
