package view;

import model.familyTree.FamilyTree;
import model.human.Human;

public interface View {
  void start();
  void print(String text);
  void setFamilyTree(FamilyTree<Human> tree);
}
