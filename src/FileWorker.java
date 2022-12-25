package src;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileWorker<T extends Human> implements SaveLoadable {

  @Override
  public void save(Serializable serializable) {
    try {
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("familyTree.out"));
      objectOutputStream.writeObject(serializable);
      objectOutputStream.close();
      System.out.println("Дерево сохранено в файл!");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @Override
  public FamilyTree<T> load(String path) {
    try {
      ObjectInputStream objectInputStream = new ObjectInputStream(
          new FileInputStream(path));
      FamilyTree<T> treeRestored = (FamilyTree<T>) objectInputStream.readObject();
      objectInputStream.close();
      System.out.println("Дерево загружено из файла!");
      return treeRestored;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public FamilyTree<T> load() {
    return load("familyTree.out");
  }
}
