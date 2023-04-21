package model.essences.comparators;

import java.util.Comparator;

import model.essences.Human;

public class HumanComparatorByDateBirth implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o2.getDateBirth().compareTo(o1.getDateBirth());
    }

}
