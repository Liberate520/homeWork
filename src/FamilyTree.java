package src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FamilyTree implements Serializable, Iterable<Human> {

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
    addHuman(new Human(fullName, gender));
  }

  public void addHuman(String fullName, String gender, Human mother, Human father) {
    addHuman(new Human(fullName, gender, mother, father));
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

  public void showHumans() {
    for (Human person : humans)
      System.out.println(person);
  }

  public List<Human> getHumanList() {
    return humans;
  }

  public Map<Integer, Human> getHumanMap(String gender) {
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
    return getHumanMap(null);
  }

  public Map<Integer, Human> chooseParent(String gender) {
    Map<Integer, Human> availableParents = getHumanMap(gender);
    System.out.println("Выберите родителя: ");
    availableParents.entrySet()
        .stream()
        .forEach(person -> System.out.println(person.getKey() + " - " +
            person.getValue()));

    return availableParents;
  }

  public void clearTree() {
    this.humans.clear();
  }

  @Override
  public Iterator<Human> iterator() {
    return new FamilyTreeIterator(humans);
  }

}
