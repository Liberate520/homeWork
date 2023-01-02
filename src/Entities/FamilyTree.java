package src.Entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import src.Service.FTIterator;

public class FamilyTree<T extends Human> implements Serializable, Iterable<T> {

  private int id = 0; // Человек получает id именно в дереве. Сама сущность id не имеет
  private Map<Integer, T> humans;

  public FamilyTree(Map<Integer, T> humans) {
    this.humans = humans;
  }

  public FamilyTree() {
    this(new HashMap<Integer, T>());
  }

  public void addHuman(T human) {
    this.humans.putIfAbsent(id++, human);
  }

  public Map.Entry<Integer, T> searchByName(String fullName) {
    for (Map.Entry<Integer, T> person : humans.entrySet()) {
      if (person.getValue()
          .getFullName()
          .toLowerCase()
          .equals(fullName.toLowerCase())) {
        return person;
      }
    }
    return null;
  }

  public Map<Integer, T> getAllHumans() {
    return humans;
  }

  public Map<Integer, T> getHumansByGender(String gender) {
    Map<Integer, T> humansWithGender = new HashMap<>();

    if (gender == null) {
      return getAllHumans();
    } else {
      for (Map.Entry<Integer, T> person : humans.entrySet()) {
        if (person.getValue()
            .getGender()
            .toLowerCase()
            .equals(gender.toLowerCase()))
          humansWithGender.putIfAbsent(person.getKey(), person.getValue());
      }
    }

    return humansWithGender;
  }

  public Map<Integer, T> chooseParent(String gender) {
    Map<Integer, T> availableParents = getHumansByGender(gender);
    // availableParents.entrySet()
    // .stream()
    // .forEach(person -> System.out.println(person.getKey() + " - " +
    // person.getValue()));

    return availableParents;
  }

  public void clearTree() {
    this.humans.clear();
  }

  @Override
  public Iterator<T> iterator() {
    return new FTIterator<T>(humans);
  }

}
