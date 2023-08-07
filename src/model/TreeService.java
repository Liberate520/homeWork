package model;

import java.time.LocalDate;

import model.familyTree.FamilyTree;
import model.human.Gender;
import model.human.Human;

public class TreeService {
  private FamilyTree<Human> tree;

  public TreeService(FamilyTree<Human> tree) {
    this.tree = tree;
  }

  public String addHuman(String name, String genderString, String birthDate, long idFather, long idMother) {
    Human father = tree.getById(idFather);
    Human mother = tree.getById(idMother);
    Gender gender = Gender.valueOf(genderString);
    LocalDate humanBirthDate = LocalDate.parse(birthDate);
    Human human = new Human(name, gender, humanBirthDate, father, mother);
    tree.add(human);
    return "Человек успешно добавлен в дерево";
  }

  public void setFamilyTree(FamilyTree<Human> tree) {
    this.tree = tree;
  }

  public void sortByName() {
    tree.sortByName();
  }

  public void sortByBirthDate() {
    tree.sortByBirthDate();
  }

  public String getHumanList() {
    return tree.getInfo();
  }
}
