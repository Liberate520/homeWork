package src.Service.TreeActions;

import src.Entities.FamilyTree;
import src.Entities.Human;

public abstract class TreeAction<T extends Human> {
  protected FamilyTree<T> tree;

  public TreeAction(FamilyTree<T> tree) {
    this.tree = tree;
  }
}
