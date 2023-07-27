package save;

import model.familyTree.FamilyTree;
import model.human.Human;

import java.io.*;

public class FamilyTreeFileManager implements FamilyTreeFileIO {
  @Override
  public void saveToFile(FamilyTree<Human> familyTree, String filename) throws IOException {
    try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(filename))) {
      objOut.writeObject(familyTree);
      System.out.println("Семейное дерево успешно сохранено в файл " + filename);
    }
  }

  @Override
  public FamilyTree<Human> loadFromFile(String filename) throws IOException, ClassNotFoundException {
    try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(filename))) {
      FamilyTree<Human> familyTree = (FamilyTree<Human>) objIn.readObject();
      System.out.println("Семейное дерево успешно загружено из файла " + filename);
      return familyTree;
    }
  }
}
