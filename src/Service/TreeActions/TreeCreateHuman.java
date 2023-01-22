package src.Service.TreeActions;

import java.util.ArrayList;
import java.util.List;

import src.Entities.FamilyTree;
import src.Entities.Human;

public class TreeCreateHuman<T extends Human> extends TreeAction<T> {
  private String fullName;
  private String gender;
  private List<T> parents = new ArrayList<>(2);

  public TreeCreateHuman(FamilyTree<T> tree) {
    super(tree);
  }

  public void setName(String fullName) {
    this.fullName = fullName;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setParent(T parent) {
    parents.add(parent);
  }

  public void createHuman() {
    if (checkNotEmpty()) {
      this.tree.addHuman((T) new Human(fullName, gender, parents.get(0), parents.get(1)));
      this.fullName = this.gender = null;
      this.parents.clear();
    }
  }

  private boolean checkNotEmpty() {

    if (this.fullName != null &&
        (this.gender.equals("Женский") || this.gender.equals("Мужской")) &&
        this.parents.size() == 2)
      return true;
    else
      return false;
  }
}
