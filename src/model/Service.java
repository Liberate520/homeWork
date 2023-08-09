package model;

import java.io.IOException;
import java.time.LocalDate;

import model.familyTree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.save.FamilyTreeFileIO;

public class Service {
  private FamilyTree<Human> tree;
  private FamilyTreeFileIO fileIo;

  public Service(FamilyTree<Human> tree) {
    this.tree = tree;
  }

  public Service(FamilyTreeFileIO fileIo) {
    this.fileIo = fileIo;
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



  public void save() {
    try {
      fileIo.saveToFile(tree, FamilyTreeFileIO.filename);
    } catch (IOException e) {
      System.err.println("Ошибка при сохранении дерева: " + e.getMessage());
    }
  }

  public FamilyTree<Human> load() {
    try {
      return fileIo.loadFromFile(FamilyTreeFileIO.filename);
    } catch (IOException | ClassNotFoundException e) {
      System.err.println("Ошибка при загрузке дерева: " + e.getMessage());
      return null;
    }
  }

  public void setFileIo(FamilyTreeFileIO fileIo) {
    this.fileIo = fileIo;
  }
}
