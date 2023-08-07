package model;

import model.familyTree.FamilyTree;
import model.human.Human;
import model.save.FamilyTreeFileIO;

import java.io.IOException;

public class FileService {
  private FamilyTreeFileIO fileIo;
  private FamilyTree<Human> tree;

  public FileService(FamilyTreeFileIO fileIo) {
    this.fileIo = fileIo;
  }

  public FileService(FamilyTree<Human> tree) {
    this.tree = tree;
  }

  public void save() {
    try {
      fileIo.saveToFile(tree, FamilyTreeFileIO.filename);
    } catch (IOException e) {
      System.err.println("Ошибка при сохранении дерева: " + e.getMessage());
    }
  }

  public FamilyTree<Human> load() {
    try {
      return fileIo.loadFromFile(FamilyTreeFileIO.filename);
    } catch (IOException | ClassNotFoundException e) {
      System.err.println("Ошибка при загрузке дерева: " + e.getMessage());
      return tree;
    }
  }

  public void setFileIo(FamilyTreeFileIO fileIo) {
    this.fileIo = fileIo;
  }
}
