package src.Service.TreeActions;

import java.util.HashMap;
import java.util.Map;

import src.Entities.FamilyTree;
import src.Entities.Human;

public class TreeFilter<T extends Human> extends TreeAction<T> {
  private Map<Integer, T> humans;

  public TreeFilter(FamilyTree<T> tree) {
    super(tree);
  }

  /**
   * 
   * @param gender
   * @return map список людей по определенному полу
   */
  public Map<Integer, T> byGender(String gender) {
    humans = tree.getHumans();

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
