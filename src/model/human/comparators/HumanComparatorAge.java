package model.human.comparators;

import java.util.Comparator;

import model.human.Human;

public class HumanComparatorAge  implements Comparator<Human> {
   public int compare(Human o1, Human o2) { return Integer.compare(o1.getAge(), o2.getAge());}
}
