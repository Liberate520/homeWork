package save;

import model.familyTree.FamilyTree;

import java.io.*;

public class FamilyTreeFileManager implements FamilyTreeFileIO {
  @Override
  public void saveToFile(FamilyTree familyTree, String filename) throws IOException {
    try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(filename))) {
      objOut.writeObject(familyTree);
      System.out.println("Семейное дерево успешно сохранено в файл " + filename);
    }
  }

  @Override
  public FamilyTree loadFromFile(String filename) throws IOException, ClassNotFoundException {
    try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(filename))) {
      FamilyTree familyTree = (FamilyTree) objIn.readObject();
      System.out.println("Семейное дерево успешно загружено из файла " + filename);
      return familyTree;
    }
  }
}
