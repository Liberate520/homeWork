package FamilyTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;;

public class FamilyTree {

  private List<Human> humans;

  public FamilyTree(List<Human> humans) {
    this.humans = humans;
  }

  public FamilyTree() {
    this(new ArrayList<>());
  }

  public void addHuman(Human human) {
    this.humans.add(human);
  }

  public void addHuman(String fullName, String gender) {
    this.humans.add(new Human(fullName, gender));
  }

  public void addHuman(String fullName, String gender, Human mother, Human father) {
    this.humans.add(new Human(fullName, gender, mother, father));
  }

  public void addHuman() {
    Scanner str = new Scanner(System.in);
    System.out.print("\nВведите имя и фамилию: ");
    String fullName = str.next() + " " + str.next();
    System.out.print("Выберите пол (введите букву: М - мужской, Ж - женский): ");
    String gender = str.next().toLowerCase();
    if (gender.equals("ж"))
      gender = "Женский";
    else
      gender = "Мужской"; // Это, конечно, не совсем корректно, но в рамках изучения ООП пока сделано так
    System.out.println("Введено: Имя " + fullName + " пол " + gender);

    Map<Integer, Human> availableMothers = chooseParent("женский");
    Human parentMother = availableMothers.get(str.nextInt());

    Map<Integer, Human> availableFathers = chooseParent("мужской");
    Human parentFather = availableFathers.get(str.nextInt());

    this.humans.add(new Human(fullName, gender, parentMother, parentFather));
  }

  public Human searchByName(String fullName) {
    for (Human person : humans) {
      if (person.getFullName().toLowerCase().equals(fullName.toLowerCase())) {
        System.out.println(person);
        return person;
      }
    }
    return null;
  }

  public Human searchByName() {
    Scanner str = new Scanner(System.in); // Если закрыть str в конце метода, то появляется ошибка в работе программы.
    System.out.println("\nВведите имя и фамилию: ");
    String fullName = str.next() + " " + str.next(); // Можно ли ссчитать два слова без двойного использования метода
                                                     // 'next()'?

    return this.searchByName(fullName);
  }

  public void moreInfo(Human person) {
    if (person != null) {
      Scanner str = new Scanner(System.in);
      System.out.println("Получить дополнительную информацию о найденном человеке? (y/n): ");
      if (str.next().toLowerCase().equals("y"))
        System.out.println(person.getInfo());
    } else {
      System.out.println("Человек не найден");
    }
  }

  public void showHumans() {
    for (Human person : humans)
      System.out.println(person);
  }

  public Map<Integer, Human> getHumans(String gender) {
    Map<Integer, Human> foundPeople = new HashMap<>();

    int count = 0;
    if (gender == null) {
      for (Human person : humans)
        foundPeople.put(++count, person);
    } else {
      for (Human person : humans) {
        if (person.getGender().toLowerCase().equals(gender.toLowerCase()))
          foundPeople.put(++count, person);
      }
    }

    return foundPeople;
  }

  public Map<Integer, Human> getHumans() {
    return getHumans(null);
  }

  private Map<Integer, Human> chooseParent(String gender) {
    Map<Integer, Human> availableParents = getHumans(gender);
    System.out.println(availableParents);
    System.out.println("Выберите родителя: ");
    availableParents.entrySet()
        .stream()
        .forEach(person -> System.out.println(person.getKey() + " - " +
            person.getValue()));

    return availableParents;
  }

}
