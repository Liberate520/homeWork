package src.Service.Tree;

import java.util.HashMap;
import java.util.Map;

import src.Entities.Human;

public class FilterTree<T extends Human> {
  private Map<Integer, T> humans;

  public FilterTree(Map<Integer, T> humans) {
    this.humans = humans;
  }

  /**
   * 
   * @param gender
   * @return map список людей по определенному полу
   */
  public Map<Integer, T> getHumansByGender(String gender) {
    Map<Integer, T> humansByGender = new HashMap<>();

    if (gender == null) {
      return humans;
    } else {

      for (Map.Entry<Integer, T> person : humans.entrySet()) {
        if (person.getValue()
            .getGender()
            .toLowerCase()
            .equals(gender.toLowerCase()))
          humansByGender.putIfAbsent(person.getKey(), person.getValue());
      }
    }

    return humansByGender;
  }

}
