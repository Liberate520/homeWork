package src;

import java.util.Comparator;

public class HumanComparatorChildCount implements Comparator<Human> {
  @Override
  public int compare(Human o1, Human o2) {
    return Integer.compare(o2.countChildren(), o1.countChildren());
  }
}
