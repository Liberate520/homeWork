package src;

import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class UserMenu<T extends Human> {
  private Scanner input = new Scanner(System.in);
  private boolean menuOn = true;
  private FileWorker<T> fw = new FileWorker<T>();

  public boolean getMenuStatus() {
    return menuOn;
  }

  public void fillHumans(FamilyTree<Human> familyTree) {
    Human ivanIvanov = new Human("Иван Иванов", "Мужской");
    Human mariaIvanova = new Human("Мария Иванова", "Женский");
    Human petrIvanov = new Human("Петр Иванов", "Мужской", mariaIvanova, ivanIvanov);

    familyTree.addHuman(ivanIvanov);
    familyTree.addHuman(mariaIvanova);
    familyTree.addHuman(petrIvanov);
  }

  public FamilyTree<T> launchMenu(FamilyTree<T> familyTree) {
    System.out.print("\nМеню:\n" +
        "1 - Показать всех людей\n" +
        "2 - Найти человека по имени и фамилии\n" +
        "3 - Добавить нового человека\n" +
        "4 - Сохранить текущее дерево в файл\n" +
        "5 - Загрузить дерево из файла\n" +
        "6 - Выход\n" +
        "Выбрано: ");
    switch (input.next()) {
      case "1":
        System.out.println("\nЛюди из семейного дерева:");
        familyTree.showHumans();
        sortHumanList(familyTree);
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
        fw.save(familyTree);
        break;

      case "5":
        System.out.println("Вы точно хотите перезаписать текущее дерево? (y/n)");
        if (checkAnswer(input.next())) {
          familyTree.clearTree();
          familyTree = fw.load();
        }
        break;

      case "6":
        this.menuOn = false;
        input.close();
        break;

      default:
        System.out.println("Выбран недействительный пункт меню");
        break;
    }
    return familyTree;
  }

  public void createHuman(FamilyTree<T> familyTree) {
    String fullName = askFullName();
    System.out.print("Выберите пол (введите букву: М - мужской, Ж - женский): ");
    String gender = input.next().toLowerCase();
    if (gender.equals("ж"))
      gender = "Женский";
    else
      gender = "Мужской";
    System.out.println("Введено: Имя " + fullName + " пол " + gender);

    Map<Integer, T> availableMothers = familyTree.chooseParent("женский");
    Human parentMother = availableMothers.get(input.nextInt());

    Map<Integer, T> availableFathers = familyTree.chooseParent("мужской");
    Human parentFather = availableFathers.get(input.nextInt());

    familyTree.addHuman((T) new Human(fullName, gender, parentMother, parentFather));
  }

  public String askFullName() {
    System.out.println("\nВведите имя и фамилию: ");
    return input.next() + " " + input.next();
  }

  public void moreInfo(Human person) {
    System.out.println("Получить дополнительную информацию о найденном человеке? (y/n): ");
    if (checkAnswer(input.next()))
      System.out.println(person.getInfo());
  }

  public FamilyTree<T> sortHumanList(FamilyTree<T> familyTree) {
    System.out.println("Отсортировать по имени? (y/n)");
    checkAnswer(input.next());
    Collections.sort(familyTree.getHumanList());
    familyTree.showHumans();
    return familyTree;
  }

  private boolean checkAnswer(String answer) {
    return answer.toLowerCase().equals("y") ? true : false;
  }

}
