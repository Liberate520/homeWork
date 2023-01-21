package src.Main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.Entities.FamilyTree;
import src.Entities.Human;
import src.Service.Tree.TreeFilter;
import src.Service.Tree.HumanComparatorChildCount;
import src.Service.Tree.SaveLoadable;
import src.Service.Tree.TreeBackup;
import src.Service.Tree.TreeCreateHuman;
import src.Service.Tree.TreeSearch;
import src.Service.Tree.TreeSort;

public class TreeService<T extends Human> implements SaveLoadable {
  private FamilyTree<T> tree;
  Map<Integer, T> backupTree = new HashMap<Integer, T>();
  TreeFilter<T> filter;
  TreeSearch<T> search;
  TreeBackup<T> backup;
  TreeSort<T> sort;

  public TreeService(FamilyTree<T> familyTree) {
    this.tree = familyTree;
    this.filter = new TreeFilter<>(familyTree);
    this.search = new TreeSearch<>(familyTree);
    this.backup = new TreeBackup<>(familyTree);
    this.sort = new TreeSort<>(familyTree);
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

  @Override
  public void save() throws IOException {
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Data/familyTree.out"));
    objectOutputStream.writeObject(tree);
    objectOutputStream.close();
  }

  @Override
  public void load(String path) throws Exception {
    ObjectInputStream objectInputStream = new ObjectInputStream(
        new FileInputStream(path));
    tree = (FamilyTree<T>) objectInputStream.readObject();
    objectInputStream.close();
  }

  @Override
  public void load() throws Exception {
    load("Data/familyTree.out");
  }
}
