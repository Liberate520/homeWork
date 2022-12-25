package src.Main;

import src.TreeFirstFill;
import src.Entities.FamilyTree;
import src.Entities.Human;

public class Program {
  public static void main(String[] args) {
    FamilyTree<Human> familyTree = new FamilyTree<Human>();
    new TreeFirstFill(familyTree);
    UserMenu menu = new UserMenu();

    while (menu.getMenuStatus()) {
      familyTree = menu.launchMenu(familyTree);
    }
  }

}
