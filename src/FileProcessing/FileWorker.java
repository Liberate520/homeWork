package src.FileProcessing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import src.Entities.FamilyTree;
import src.Entities.Human;

public class FileWorker<T extends Human> implements SaveLoadable {

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
    FamilyTree<T> treeRestored = (FamilyTree<T>) objectInputStream.readObject();
    objectInputStream.close();
    return treeRestored;
  }

  @Override
  public FamilyTree<T> load() throws Exception {
    return load("Data/familyTree.out");
  }
}
