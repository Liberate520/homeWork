package src;

import java.util.Map;
import java.util.Scanner;

public class UserMenu {
  private Scanner input = new Scanner(System.in);
  private boolean menuOn = true;

  public boolean getMenuStatus() {
    return menuOn;
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
        "\nМеню:\n1 - Показать всех людей\n2 - Найти человека по имени и фамилии\n3 - Добавить нового человека\n4 - Выход\nВыбрано: ");
    switch (input.next()) {
      case "1":
        System.out.println("\nЛюди из семейного дерева:");
        familyTree.showHumans();
        break;

      case "2":
        Human person = familyTree.searchByName(askFullName());
        if (person != null)
          moreInfo(person);
        else
          System.out.println("Человек не найден");
        break;

      case "3":
        createHuman(familyTree);
        familyTree.showHumans();
        break;

      case "4":
        this.menuOn = false;
        return;

      default:
        System.out.println("Выбран недействительный пункт меню");
        break;
    }
  }

  public void createHuman(FamilyTree familyTree) {
    String fullName = askFullName();
    System.out.print("Выберите пол (введите букву: М - мужской, Ж - женский): ");
    String gender = input.next().toLowerCase();
    if (gender.equals("ж"))
      gender = "Женский";
    else
      gender = "Мужской";
    System.out.println("Введено: Имя " + fullName + " пол " + gender);

    Map<Integer, Human> availableMothers = familyTree.chooseParent("женский");
    Human parentMother = availableMothers.get(input.nextInt());

    Map<Integer, Human> availableFathers = familyTree.chooseParent("мужской");
    Human parentFather = availableFathers.get(input.nextInt());

    familyTree.addHuman(new Human(fullName, gender, parentMother, parentFather));
  }

  public String askFullName() {
    System.out.println("\nВведите имя и фамилию: ");
    return input.next() + " " + input.next();
  }

  public void moreInfo(Human person) {
    System.out.println("Получить дополнительную информацию о найденном человеке? (y/n): ");
    if (input.next().toLowerCase().equals("y"))
      System.out.println(person.getInfo());
  }

  public void closeInput() {
    input.close();
  }
}
