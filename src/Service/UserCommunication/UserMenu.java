package src.Service.UserCommunication;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import src.Entities.Human;
import src.Service.Commands.Executable;

public class UserMenu<T extends Human> {

  public void newMainMenu(List<Executable> commands) {
    for (int i = 0; i < commands.size(); i++)
      System.out.println(i + " - " + commands.get(i).description());
    System.out.println("q - Выход");
  }

  public void mainMenu() {
    Map<String, String> menu = new LinkedHashMap<>() {
      {
        put("1", "Показать всех людей");
        put("2", "Найти человека по имени и фамилии");
        put("3", "Добавить нового человека");
        put("4", "Сохранить текущее дерево в файл");
        put("5", "Загрузить дерево из файла");
        put("q", "Выход");
      }
    };

    showMenu(menu);
  }

  public void sortMenu() {
    Map<String, String> menu = new LinkedHashMap<>() {
      {
        put("1", "Сортировка по имени");
        put("2", "Сортировка по количеству детей");
        put("q", "Не применять сортировку");
      }
    };

    showMenu(menu);
  }

  private void showMenu(Map<String, String> menu) {
    System.out.println("");
    for (Map.Entry<String, String> menuPoint : menu.entrySet()) {
      System.out.println(String.format("%s - %s", menuPoint.getKey(), menuPoint.getValue()));
    }
    System.out.print("Выбрано: ");
  }

  public void textBeforeShowHumans() {
    System.out.println("\nЛюди из семейного дерева:");
  }

  public void textIncorrectInput() {
    System.out.println("Некорректный ввод");
  }

  public void showHumans(Map<Integer, T> humans) {
    for (Map.Entry<Integer, T> person : humans.entrySet())
      System.out.println("id: " + person.getKey() + ", " + person.getValue());
  }

  public void showHumanList(List<T> peopleList) {
    System.out.println("Отсортированный список:");
    for (T person : peopleList)
      System.out.println(String.format("Имя: %s, пол: %s", person.getFullName(), person.getGender()));
  }

  public void askFullName() {
    System.out.println("\nВведите имя и фамилию:");
  }

  public void askGender() {
    System.out.println("\nВыберите пол (введите букву: М - мужской, Ж - женский): ");
  }

  public void askParent() {
    System.out.println("Выберите родителя: ");
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

  public void askReplaceTree() {
    System.out.println("Вы точно хотите перезаписать текущее дерево? (y/n)");
  }

  public void textSaveAction(boolean success) {
    if (success)
      System.out.println("Дерево сохранено в файл!");
    else
      System.out.println("Не удалось сохранить дерево в файл!");
  }

  public void textLoadAction(boolean success) {
    if (success)
      System.out.println("Дерево загружено из файла!");
    else
      System.out.println("Не удалось загрузить дерево из файла");
  }
}
