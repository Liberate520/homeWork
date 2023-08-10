package model.human;

import java.util.Comparator;

import model.familyTree.TreeItem;

public class ComporatorByName<E extends TreeItem<E>> implements Comparator<E> {
  @Override
  public int compare(E o1, E o2){
    return o1.getName().compareTo(o2.getName());
  }

}
