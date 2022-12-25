package src;

import src.Entities.FamilyTree;
import src.Entities.Human;

public class FamilyTreeService<T extends Human> {
  private FamilyTree<T> familyTree;

  public FamilyTreeService(FamilyTree<T> familyTree) {
    this.familyTree = familyTree;
  }

}
