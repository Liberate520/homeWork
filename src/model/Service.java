package model;

import java.io.IOException;
import java.time.LocalDate;

import model.familyTree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.save.FamilyTreeFileIO;

public class Service {
  private FamilyTreeFileIO fileIo;
  private FamilyTree<Human> tree;

  public Service(FamilyTree<Human> tree) {
    this.tree = tree;
  }

  public Service() {
    this(new FamilyTree<>());
}


  public void save() throws IOException {
    fileIo.saveToFile(tree, FamilyTreeFileIO.filename);
  }

  public FamilyTree<Human> load() throws ClassNotFoundException, IOException {
    return tree = fileIo.loadFromFile(FamilyTreeFileIO.filename);
  }

  public String addHuman(String name, String genderString, String birthDate,
      long idFather, long idMother) {
    Human father = tree.getById(idFather);
    Human mother = tree.getById(idMother);
    Gender gender = Gender.valueOf(genderString);
    LocalDate humanBirthDate = LocalDate.parse(birthDate);
    Human human = new Human(name, gender, humanBirthDate, father, mother);
    tree.add(human);
    return "Человек успешно добавлен в дерево";
  }

  public void setFileIo(FamilyTreeFileIO fileIo){
    this.fileIo = fileIo;
  }

  public void setFamilyTree(FamilyTree<Human> tree) {
    this.tree = tree;
  }

  public void sortByName(){
    tree.sortByName();

  }

  public void sortByBirthDate(){
    tree.sortByBirthDate();
  }

  public String getHumanList(){
    return tree.getInfo();
  }
}
