package presenter;

import model.TreeService;
import model.familyTree.FamilyTree;
import model.human.Human;
import view.View;

public class Presenter {
  private View view;
  private TreeService treeService;

  public Presenter(View view, FamilyTree<Human> tree) {
    this.view = view;
    treeService = new TreeService(tree);

  }

  public void addHuman(String name, String gender, String birthDate, long idFather, long idMother) {
    String answer = treeService.addHuman(name, gender, birthDate, idFather, idMother);
    view.print(answer);
  }

  public void getHumanList() {
    String answer = treeService.getHumanList();
    view.print(answer);
  }

  public void sortByName() {
    treeService.sortByName();
  }

  public void sortByBirthDate() {
    treeService.sortByBirthDate();
  }

  public void setFamilyTree(FamilyTree<Human> tree) {
    treeService.setFamilyTree(tree);
  }
}
