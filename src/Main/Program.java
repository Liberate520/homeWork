package src.Main;

import src.Entities.FamilyTree;
import src.Entities.Human;
import src.Service.Tree.FTFirstFill;

public class Program {
  public static void main(String[] args) {
    FamilyTree<Human> familyTree = new FamilyTree<Human>();
    new FTFirstFill(familyTree);
    Controller<Human> control = new Controller(familyTree);

    while (control.getControllerStatus()) {
      control.startControl();
    }
  }

}
