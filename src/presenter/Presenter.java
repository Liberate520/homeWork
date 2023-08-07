package presenter;

import model.Service;
import model.familyTree.FamilyTree;
import model.human.Human;
import view.Console;
import view.View;

public class Presenter {
  private View view;
  private Service service;

  public Presenter(View view, FamilyTree<Human> tree) {
    service = new Service(tree);
    this.view = view;
  }

  public Presenter(View view) {
    this.view = view;
    this.service = new Service();
  }

  public void setFamilyTree(FamilyTree<Human> tree) {
    service.setFamilyTree(tree);
  }

  public void addHuman(String name, String gender, String birthDate, long idFather, long idMother) {
    String answer = service.addHuman(name, gender, birthDate, idFather, idMother);
    view.print(answer);
  }

  public void getHumanList() {
    String answer = service.getHumanList();
    view.print(answer);
  }

  public void sortByName() {
    service.sortByName();
  }

  public void sortByBirthDate() {
    service.sortByBirthDate();
  }
}
