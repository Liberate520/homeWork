package src;

public class Program {
  public static void main(String[] args) {
    FamilyTree<Human> familyTree = new FamilyTree<Human>();
    UserMenu menu = new UserMenu();

    menu.fillHumans(familyTree);

    while (menu.getMenuStatus()) {
      familyTree = menu.launchMenu(familyTree);
    }
  }

}
