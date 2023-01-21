package src.Entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import src.Service.Tree.FTIterator;

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

  /**
   * Очищает дерево
   */
  public void clearTree() {
    this.humans.clear();
  }

  public Map<Integer, T> getHumans() {
    return humans;
  }

  /**
   * Производит поиск в дереве человека по полному имени
   * 
   * @param fullName
   * @return найденный человек (экземпляр класса Human) или null, если результата
   *         нет
   */
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

  @Override
  public Iterator<T> iterator() {
    return new FTIterator<T>(humans);
  }

}
