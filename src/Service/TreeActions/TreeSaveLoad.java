package src.Service.TreeActions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import src.Entities.FamilyTree;
import src.Entities.Human;
import src.Service.Tree.SaveLoadable;

public class TreeSaveLoad<T extends Human> extends TreeAction<T> implements SaveLoadable {

  public TreeSaveLoad(FamilyTree<T> tree) {
    super(tree);
  }

  @Override
  public void save() throws IOException {
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Data/familyTree.out"));
    objectOutputStream.writeObject(tree);
    objectOutputStream.close();
  }

  @Override
  public FamilyTree<T> load(String path) throws Exception {
    ObjectInputStream objectInputStream = new ObjectInputStream(
        new FileInputStream(path));
    tree = (FamilyTree<T>) objectInputStream.readObject();
    objectInputStream.close();
    return tree;
  }

  @Override
  public FamilyTree<T> load() throws Exception {
    return load("Data/familyTree.out");
  }

}
