package src.Main;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.Entities.FamilyTree;
import src.Entities.Human;
import src.Service.TreeActions.*;

public class TreeService<T extends Human> {
  private FamilyTree<T> tree;
  Map<Integer, T> backupTree = new HashMap<Integer, T>();
  private TreeFilter<T> filter;
  private TreeSearch<T> search;
  private TreeBackup<T> backup;
  private TreeSort<T> sort;
  private TreeSaveLoad<T> file;

  public TreeService(FamilyTree<T> familyTree) {
    this.tree = familyTree;
    this.filter = new TreeFilter<>(familyTree);
    this.search = new TreeSearch<>(familyTree);
    this.backup = new TreeBackup<>(familyTree);
    this.sort = new TreeSort<>(familyTree);
    this.file = new TreeSaveLoad<>(familyTree);
  }

  public Map<Integer, T> chooseParent(String gender) {
    return filter.byGender(gender);
  }

  public void clearTree() {
    tree.clearTree();
  }

  public void createBackup() {
    backup.create();
  }

  public void restoreBackup() {
    backup.restore();
  }

  public Map<Integer, T> getHumans() {
    return tree.getHumans();
  }

  public void createHuman(String fullName, String gender, T parentMother, T parentFather) {
    tree.addHuman((T) new Human(fullName, gender, parentMother, parentFather));
  }

  // public void testCreateHuman() {
  // TreeCreateHuman tch = new TreeCreateHuman<>(tree);

  // tch.setName(null);
  // tch.setGender(null);
  // tch.setParent(chooseParent("женский"));

  // tch.setParent(chooseParent("мужской"));

  // tch.createHuman();
  // }

  public Map.Entry<Integer, T> searchByName(String fullName) {
    return search.byName(fullName);
  }

  public List<T> sortByName() {
    return sort.byName();
  }

  public List<T> sortByNumberOfChildren() {
    return sort.byNumberOfChildren();
  }

  public boolean save() {
    try {
      file.save();
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean load(String path) {
    try {
      this.tree = file.load(path);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean load() {
    return load("Data/familyTree.out");
  }
}
