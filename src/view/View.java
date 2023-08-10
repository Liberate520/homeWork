package view;

import model.familyTree.FamilyTree;
import model.human.Human;
import model.save.FamilyTreeFileIO;

public interface View {
  void start();
  public void setFamilyTree(FamilyTree<Human> tree);
  void print(String text);
  public void setFileIo(FamilyTreeFileIO fileIo);
  void exit();
}
