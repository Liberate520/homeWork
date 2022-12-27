package src.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import src.HumanComparatorChildCount;
import src.Entities.FamilyTree;
import src.Entities.Human;
import src.FileProcessing.FileWorker;

public class UserMenu<T extends Human> {
  private Scanner input = new Scanner(System.in);
  private boolean menuOn = true;
  private FileWorker<T> fw = new FileWorker<T>();

  public boolean getMenuStatus() {
    return menuOn;
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
        askToSort(familyTree);
        break;

      case "2":
        T person = familyTree.searchByName(askFullName());
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

    System.out.println("Выберите мать: ");
    Map<Integer, T> availableMothers = familyTree.chooseParent("женский");
    Human parentMother = availableMothers.get(input.nextInt());

    System.out.println("Выберите отца: ");
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

  public void askToSort(FamilyTree<T> familyTree) {
    System.out.println("Применить сортировку:\n" +
        "1 - Сортировка по имени\n" +
        "2 - Сортировка по количеству детей\n" +
        "3 - Не применять сортировку");
    switch (input.next()) {
      case "1":
        sortByName(familyTree);
        break;

      case "2":
        sortByNumberOfChildren(familyTree);
        break;

      case "3":
        break;

      default:
        System.out.println("Некорректный ввод");
        break;
    }
  }

  public void sortByName(FamilyTree<T> familyTree) {
    List<T> peopleList = new ArrayList<T>(familyTree.getAllHumans().values());
    Collections.sort(peopleList);
    System.out.println("Отсортированный список:");
    showAfterSort(peopleList);
  }

  public void sortByNumberOfChildren(FamilyTree<T> familyTree) {
    List<T> peopleList = new ArrayList<T>(familyTree.getAllHumans().values());
    Collections.sort(peopleList, new HumanComparatorChildCount());
    showAfterSort(peopleList);
  }

  public void showAfterSort(List<T> peopleList) {
    for (T person : peopleList)
      System.out.println(String.format("Имя: %s, пол: %s", person.getFullName(), person.getGender()));
  }

  private boolean checkAnswer(String answer) {
    return answer.toLowerCase().equals("y") ? true : false;
  }

}
