package Alive.Human.Comparators;

import Alive.Human.Human;

import java.util.Comparator;

public class HumanComparatorByDataDie implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getDie().compareTo(o2.getDie());
    }
}
