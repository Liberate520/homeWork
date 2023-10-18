package model.service;

import java.time.LocalDate;

import Writer.Writable;
import model.famailyTree.FamilyTree;
import model.human.Gender;
import model.human.Human;

public class FamilyTreeService {
  private Writable writable;
  private FamilyTree<Human> familyTree;

  public FamilyTreeService() {
    familyTree = new FamilyTree<>();
  }

  public String addHuman(String name, String firstName, String lastName, String genderString, String birthDate,
      long idFather, long idMother) {
    Human father = familyTree.getById(idFather);
    Human mother = familyTree.getById(idMother);
    Gender gender = Gender.valueOf(genderString);
    LocalDate humanBirthDate = LocalDate.parse(birthDate);
    Human human = new Human(name, firstName, lastName, humanBirthDate, humanBirthDate, gender);
    familyTree.add(human);
    return "Человек успешно добавлен в дерево";
  }

  public void setWritable(Writable writable) {
    this.writable = writable;
  }

  public void sortByName() {
    familyTree.sortByName();
  }

  public void sortBirthDay() {
    familyTree.sortBirthDay();
  }

  public String getHumanList() {
    return familyTree.Info();
  }

}
