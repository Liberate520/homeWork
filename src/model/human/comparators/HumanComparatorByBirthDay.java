package model.human.comparators;

import java.util.Comparator;

import model.human.Human;

public class HumanComparatorByBirthDay implements Comparator <Human>{
   public int compare(Human o1, Human o2) { return o1.getBirthDate().compareTo(o2.getBirthDate());}
}
