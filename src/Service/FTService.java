package src.Service;

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

public class FTService<T extends Human> implements SaveLoadable {
  private FamilyTree<T> tree;
  Map<Integer, T> backupTree = new HashMap<Integer, T>();

  public FTService(FamilyTree<T> familyTree) {
    this.tree = familyTree;
  }

  public Map<Integer, T> getAllHumans() {
    return tree.getAllHumans();
  }

  public Map<Integer, T> chooseParent(String gender) {
    return tree.chooseParent(gender);
  }

  public void createHuman(String fullName, String gender, T parentMother, T parentFather) {
    tree.addHuman((T) new Human(fullName, gender, parentMother, parentFather));
  }

  public void clearTree() {
    tree.clearTree();
  }

  public Map.Entry<Integer, T> searchByName(String fullName) {
    return tree.searchByName(fullName);
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

  public void createBackup() {
    backupTree.putAll(getAllHumans());
  }

  public void restoreFromBackup() {
    getAllHumans().putAll(backupTree);
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
