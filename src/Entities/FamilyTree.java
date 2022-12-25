package src.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import src.FamilyTreeIterator;

public class FamilyTree<T extends Human> implements Serializable, Iterable<T> {

  private List<T> humans; // Наименование human осавлено
  // т.к. T extends Human (T все равно будет каким-либо человеком в данном
  // конкретном случае)

  public FamilyTree(List<T> humans) {
    this.humans = humans;
  }

  public FamilyTree() {
    this(new ArrayList<>());
  }

  public void addHuman(T human) {
    this.humans.add(human);
  }

  public Human searchByName(String fullName) {
    for (T human : humans) {
      if (human.getFullName().toLowerCase().equals(fullName.toLowerCase())) {
        System.out.println(human);
        return human;
      }
    }
    return null;
  }

  public void showHumans() {
    for (T human : humans)
      System.out.println(human);
  }

  public List<T> getHumanList() {
    return humans;
  }

  public Map<Integer, T> getHumanMap(String gender) {
    Map<Integer, T> foundPeople = new HashMap<>();

    int count = 0;
    if (gender == null) {
      for (T person : humans)
        foundPeople.put(++count, person);
    } else {
      for (T person : humans) {
        if (person.getGender().toLowerCase().equals(gender.toLowerCase()))
          foundPeople.put(++count, person);
      }
    }

    return foundPeople;
  }

  public Map<Integer, T> getHumans() {
    return getHumanMap(null);
  }

  public Map<Integer, T> chooseParent(String gender) {
    Map<Integer, T> availableParents = getHumanMap(gender);
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
  public Iterator<T> iterator() {
    return new FamilyTreeIterator<T>(humans);
  }

}
