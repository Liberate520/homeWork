package presenter;

import model.Service;
import model.familyTree.FamilyTree;
import model.human.Human;
import model.save.FamilyTreeFileIO;
import view.View;

public class Presenter {
  private View view;
  private Service service;

  public Presenter(View view, FamilyTree<Human> tree) {
    this.view = view;
    service = new Service(tree);
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

  public void setFamilyTree(FamilyTree<Human> tree) {
    service.setFamilyTree(tree);
  }

  public void save() {
    service.save();
  }

  public void load() {
    
    service.load();
  }

  public void setFileIo(FamilyTreeFileIO fileIo) {
    service.setFileIo(fileIo);
  }
}
