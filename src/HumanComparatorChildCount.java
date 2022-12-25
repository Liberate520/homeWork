package src;

import java.util.Comparator;

import src.Entities.Human;

public class HumanComparatorChildCount implements Comparator<Human> {
  @Override
  public int compare(Human o1, Human o2) {
    return Integer.compare(o2.getNumberOfChildren(), o1.getNumberOfChildren());
  }
}
