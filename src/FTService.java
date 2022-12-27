package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.Entities.FamilyTree;
import src.Entities.Human;

public class FTService<T extends Human> {
  private FamilyTree<T> tree;

  public FTService(FamilyTree<T> familyTree) {
    this.tree = familyTree;
  }

  public List<T> sortByName() {
    List<T> humanList = new ArrayList<T>(tree.getAllHumans().values());
    Collections.sort(humanList);
    return humanList;
  }

  public List<T> sortByNumberOfChildren() {
    List<T> humanList = new ArrayList<T>(tree.getAllHumans().values());
    Collections.sort(humanList, new HumanComparatorChildCount());
    return humanList;
  }

  public void showAfterSort(List<T> peopleList) {
    for (T person : peopleList)
      System.out.println(String.format("Имя: %s, пол: %s", person.getFullName(), person.getGender()));
  }

}
