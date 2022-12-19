package src;

import java.util.Scanner;

public class UserMenu {
  private Scanner input = new Scanner(System.in);
  private String stringData;
  private int intData;

  public String askString() {
    return input.next();
  }

  public int askInt() {
    return input.nextInt();
  }

  public void firstFill(FamilyTree familyTree) {
    Human ivanIvanov = new Human("Иван Иванов", "Мужской");
    Human mariaIvanova = new Human("Мария Иванова", "Женский");
    Human petrIvanov = new Human("Петр Иванов", "Мужской", mariaIvanova, ivanIvanov);

    familyTree.addHuman(ivanIvanov);
    familyTree.addHuman(mariaIvanova);
    familyTree.addHuman(petrIvanov);
  }

  public void launchMenu(FamilyTree familyTree) {
    System.out.print(
        "Меню:\n1 - Показать всех людей\n2 - Найти человека по имени и фамилии\n3 - Добавить нового человека\n4 - Выход\nВыбрано: ");
    stringData = input.next();
    switch (stringData) {
      case "1":
        System.out.println("\nЛюди из семейного дерева:");
        familyTree.showHumans();
        break;

      case "2":
        Human person = familyTree.askName();
        familyTree.moreInfo(person);
        break;

      case "3":
        familyTree.createHuman();
        familyTree.showHumans();
        break;

      case "4":
        // str.close();
        return;

      default:
        System.out.println("Выбран недействительный пункт меню");
        break;
    }
  }

  public void closeInput() {
    input.close();
  }
}
