package src;

import java.util.Scanner;

public class Program {
  public static void main(String[] args) {
    FamilyTree familyTree = new FamilyTree();
    UserMenu menu = new UserMenu();

    menu.firstFill(familyTree);
    menu.launchMenu(familyTree);

  }

}
