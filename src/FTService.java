package src;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.Entities.FamilyTree;
import src.Entities.Human;
import src.FileProcessing.SaveLoadable;

public class FTService<T extends Human> implements SaveLoadable {
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

  @Override
  public void save(Serializable serializable) throws IOException {
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Data/familyTree.out"));
    objectOutputStream.writeObject(serializable);
    objectOutputStream.close();
  }

  @Override
  public FamilyTree<T> load(String path) throws Exception {
    ObjectInputStream objectInputStream = new ObjectInputStream(
        new FileInputStream(path));
    FamilyTree<T> treeRestored = (FamilyTree<T>) objectInputStream.readObject(); // To check
    objectInputStream.close();
    return treeRestored;
  }

  @Override
  public FamilyTree<T> load() throws Exception {
    return load("Data/familyTree.out");
  }
}
