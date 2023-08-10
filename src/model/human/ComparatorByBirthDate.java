package model.human;

import java.util.Comparator;

import model.familyTree.TreeItem;

public class ComparatorByBirthDate<E extends TreeItem<E>> implements Comparator<E> {
  @Override
  public int compare(E o1, E o2){
    return o2.getBirthDate().compareTo(o1.getBirthDate());
  }
  
}
