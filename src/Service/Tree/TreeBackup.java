package src.Service.Tree;

import java.util.HashMap;
import java.util.Map;

import src.Entities.FamilyTree;
import src.Entities.Human;

public class TreeBackup<T extends Human> {
  FamilyTree<T> tree;
  Map<Integer, T> backup = new HashMap<Integer, T>();

  public TreeBackup(FamilyTree<T> tree) {
    this.tree = tree;
  }

  public void create() {
    backup.putAll(tree.getHumans());
  }

  public void restore() {
    tree.getHumans().putAll(backup);
  }
}
