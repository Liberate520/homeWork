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
      System.out.println("Ошибка записи в файл: " + ioErr);
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
    } catch (IOException ioErr) {
      System.out.println("Ошибка чтения файла: " + ioErr);
      return null;
    } catch (ClassNotFoundException classErr) {
      System.out.println("Ошибка чтения файла (не найден класс): " + classErr);
      return null;
    }
  }

  public FamilyTree load() {
    return load("src/familyTree.out");
  }
}
