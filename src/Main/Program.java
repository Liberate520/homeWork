package src.Main;

import src.Entities.FamilyTree;
import src.Entities.Human;
import src.Service.Tree.TreeFillData;

public class Program {
  public static void main(String[] args) {
    FamilyTree<Human> familyTree = new FamilyTree<Human>();
    new TreeFillData(familyTree);
    Controller<Human> control = new src.Main.Controller<>(familyTree);

    while (control.getControllerStatus()) {
      control.startControl();
    }
  }

}
