package FamilyTree;

import java.util.Scanner;

public class Program {
  public static void main(String[] args) {
    FamilyTree familyTree = new FamilyTree();

    Human ivanIvanov = new Human("Иван Иванов", "Мужской");
    Human mariaIvanova = new Human("Мария Иванова", "Женский");
    Human petrIvanov = new Human("Петр Иванов", "Мужской", mariaIvanova, ivanIvanov);

    familyTree.addHuman(ivanIvanov);
    familyTree.addHuman(mariaIvanova);
    familyTree.addHuman(petrIvanov);

    Scanner str = new Scanner(System.in);

    System.out.print(
        "Меню:\n1 - Показать всех людей\n2 - Найти человека по имени и фамилии\n3 - Добавить нового человека\n4 - Выход\nВыбрано: ");

    String selectedItem = str.next();
    switch (selectedItem) {
      case "1":
        System.out.println("\nЛюди из семейного дерева:");
        familyTree.showHumans();
        break;

      case "2":
        Human person = familyTree.searchByName();
        familyTree.moreInfo(person);
        break;

      case "3":
        familyTree.addHuman();
        familyTree.showHumans();
        break;

      case "4":
        str.close();
        return;

      default:
        System.out.println("Выбран недействительный пункт меню");
        break;
    }
    str.close();
  }

}
