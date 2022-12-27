package src.Main;

import java.util.List;
import java.util.Map;

import src.Entities.Human;

public class UserMenu<T extends Human> {

  public void showMenu() {
    System.out.print("\nМеню:\n" +
        "1 - Показать всех людей\n" +
        "2 - Найти человека по имени и фамилии\n" +
        "3 - Добавить нового человека\n" +
        "4 - Сохранить текущее дерево в файл\n" +
        "5 - Загрузить дерево из файла\n" +
        "6 - Выход\n" +
        "Выбрано: ");
  }

  public void textBeforeShowHumans() {
    System.out.println("\nЛюди из семейного дерева:");
  }

  public void textAskToSort() {
    System.out.println("Применить сортировку:\n" +
        "1 - Сортировка по имени\n" +
        "2 - Сортировка по количеству детей\n" +
        "3 - Не применять сортировку");
  }

  public void textIncorrectInput() {
    System.out.println("Некорректный ввод");
  }

  public void showHumanList(List<T> peopleList) {
    System.out.println("Отсортированный список:");
    for (T person : peopleList)
      System.out.println(String.format("Имя: %s, пол: %s", person.getFullName(), person.getGender()));
  }

  public void askFullName() {
    System.out.println("\nВведите имя и фамилию:");
  }

  public void foundByName(Map.Entry<Integer, T> human) {
    System.out.println("id: " + human.getKey() + " имя: " + human.getValue());
  }

  public void humanNotFound() {
    System.out.println("Человек не найден");
  }

  public void showInfo(String info) {
    System.out.println(info);
  }

  public void dialogCreateHuman(String stage) {
    switch (stage) {
      case "askName":
        askFullName();
        break;

      case "askGender":
        System.out.print("Выберите пол (введите букву: М - мужской, Ж - женский): ");
        break;

      case "askParent":
        System.out.println("Выберите родителя: ");
        break;
    }
  }
}
