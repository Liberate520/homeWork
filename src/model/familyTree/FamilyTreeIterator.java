package model.familyTree;

import java.util.Iterator;
import java.util.List;

import model.human.Human;

public class FamilyTreeIterator implements Iterator<Human> {
  private List list;
  private int index;

  public FamilyTreeIterator(List list){
    this.list = list;
    index = 0;
  }

  @Override
  public boolean hasNext() {
    return index < list.size();
  }

  @Override
  public Human next() {
    return (Human) list.get(index++);
  }
}
