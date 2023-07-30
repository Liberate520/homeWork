package Alive.Human.Comparators;

import Alive.Human.Human;

import java.util.Comparator;

public class HumanComparatorByDataBorn implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
      return   o1.getBorn().compareTo(o2.getBorn());
    }
}
