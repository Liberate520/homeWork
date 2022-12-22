package src;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {
  private int index;
  private List<Human> humans;

  public FamilyTreeIterator(List<Human> humans) {
    this.humans = humans;
  }

  @Override
  public boolean hasNext() {
    return index < humans.size();
  }

  @Override
  public Human next() {
    return humans.get(index++);
  }

}
