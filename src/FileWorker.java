package src;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileWorker {

  public void save(Serializable serializable) {
    try {
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/familyTree.out"));
      objectOutputStream.writeObject(serializable);
      objectOutputStream.close();
      System.out.println("Дерево сохранено в файл!");
    } catch (IOException ioErr) {
      ioErr.getLocalizedMessage();
    }

  }

  public FamilyTree load(String path) {
    try {
      ObjectInputStream objectInputStream = new ObjectInputStream(
          new FileInputStream(path));
      FamilyTree treeRestored = (FamilyTree) objectInputStream.readObject();
      objectInputStream.close();
      System.out.println("Дерево загружено из файла!");
      return treeRestored;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public FamilyTree load() {
    return load("src/familyTree.out");
  }
}
