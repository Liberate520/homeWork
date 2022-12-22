package src;

public class Program {
  public static void main(String[] args) {
    FamilyTree familyTree = new FamilyTree();
    UserMenu menu = new UserMenu();

    menu.firstFill(familyTree);

    while (menu.getMenuStatus()) {
      familyTree = menu.launchMenu(familyTree);

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.getLocalizedMessage();
      }
    }
  }

}
