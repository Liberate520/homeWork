package src;

import java.util.Map;
import java.util.Scanner;

public class UserMenu {
  private Scanner input = new Scanner(System.in);
  private boolean menuOn = true;
  private FileWorker fw = new FileWorker();

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
        "\nМеню:\n1 - Показать всех людей\n2 - Найти человека по имени и фамилии\n3 - Добавить нового человека\n4 - Сохранить текущее дерево в файл\n5 - Загрузить дерево из файла\n6 - Выход\nВыбрано: ");
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
        fw.save(familyTree); // Объект интерфейса Serializable
        break;

      case "5":
        System.out.println("Вы точно хотите перезаписать текущее дерево? (y/n)");
        if (checkAnswer(input.next())) {
          familyTree.clearTree();
          familyTree = fw.load(); // Как выйти из порочного круга?
          familyTree.showHumans(); // Отобразит загруженное дерево. Но только 1 раз.
          /*
           * Полагаю, после выполнения загрузки - перезаписывается только
           * локальная переменная familiTree внутри функции.
           * В файле 'Program.java' 11 строка: меню снова запускается с внешней переменной
           * а данная внешняя переменная пустая. Из-за чего вывод пустой.
           */
        }
        break;

      case "6":
        this.menuOn = false;
        input.close();
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
    if (checkAnswer(input.next()))
      System.out.println(person.getInfo());
  }

  private boolean checkAnswer(String answer) {
    return answer.toLowerCase().equals("y") ? true : false;
  }
}
