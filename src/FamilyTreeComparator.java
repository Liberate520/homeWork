package src;

import java.util.Iterator;
import java.util.Map;

import src.Entities.Human;

public class FamilyTreeComparator<T extends Human> implements Iterator<T> {
  private int index;
  private Map<Integer, T> humans;

  public FamilyTreeComparator(Map<Integer, T> humans) {
    this.humans = humans;
  }

  @Override
  public boolean hasNext() {
    return index < humans.size();
  }

  @Override
  public T next() {
    return humans.get(index++);
  }

}
