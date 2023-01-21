package src.Service.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.Entities.FamilyTree;
import src.Entities.Human;

public class TreeSort<T extends Human> {
  private FamilyTree<T> tree;
  List<T> humanList;

  public TreeSort(FamilyTree<T> tree) {
    this.tree = tree;
  }

  protected void fillHumanList() {
    humanList = new ArrayList<T>(tree.getHumans().values());
  }

  public List<T> byName() {
    fillHumanList();
    Collections.sort(humanList);
    return humanList;
  }

  public List<T> byNumberOfChildren() {
    fillHumanList();
    Collections.sort(humanList, new HumanComparatorChildCount());
    return humanList;
  }

}
