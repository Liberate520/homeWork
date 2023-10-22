package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.human.Gender;
import model.human.Human;


public class Service {
  private FamilyTree<Human> familyTree;
  private FileHandler fileHandler;
  private NewHuman newHuman;
  private FindHuman findHuman;

  public Service(FamilyTree<Human> familyTree, FileHandler fileHandler) {
    this.familyTree = familyTree;
    this.fileHandler = fileHandler;
    this.newHuman = new NewHuman(familyTree);
    this.findHuman = new FindHuman(familyTree);
  }

  private void setFamilyTree(FamilyTree<Human> familyTree) {
    this.familyTree = familyTree;
  }

  public String getFileName() {
    return fileHandler.getFileName();
  }

  public String getFileType() {
    return fileHandler.getFileType();
  }

  public Human readNewHuman() {
    return newHuman.readNewHuman();
  }

  public void getHumanByName() {
    findHuman.getHumanByName();
  }

  public void addHuman(Human human) {
    familyTree.addHuman(human);
  }

  public void writeTreeInFile() throws IOException {
    fileHandler.writeTreeInFile(familyTree);
  }

  public void readFromFile() throws IOException, ClassNotFoundException {
    setFamilyTree(fileHandler.readFromFile());
  }

  public void sortByParameter(int sortNumber) {
    familyTree.sortByParameter(sortNumber);
  }

  public void printChildren() {
    System.out.println("Список дерева с указанием наличия (отсутствия) детей: ");
    int index = 1;
    for (Human humanTemp : familyTree.getFamilyTree()) {
      if (humanTemp.getChildren().isEmpty()) {
        System.out.printf("%d)id: %d; %s(%d) не имеет детей!\n",
            index++, humanTemp.getId(), humanTemp.getFulName(), humanTemp.getBirthDate());
        System.out.println();
      } else {
        System.out.printf("%id)id: %id; %s (%id) имеет следуюющих детекй: \n %s\n", index++,
            humanTemp.getId(), humanTemp.getFulName(), humanTemp.getBirthDate(), humanTemp.getChildren());
        System.out.println();
      }
    }
  }

  public void print() {
    System.out.println("Список родственников состоит: ");

    while (familyTree.hasNext()) {
      System.out.println(familyTree.next().toString());
    }
  }

  public void createInitialTree() {
    int id = 0;
    Human h_1 = new Human(id++, "Кожедуб Нионила Леонтьевна", 1947, 2015, Gender.Female, null, null);
    Human h_2 = new Human(id++, "Кожедуб Иван Иванович", 1941, Gender.Male, null, null);
    Human h_3 = new Human(id++, "Кожедуб Людмила Карповна", 1932, 2012, Gender.Female, null, null);
    Human h_4 = new Human(id++, "Кожедуб Павел Карпович", 1930, Gender.Male, null, null);
    Human h_5 = new Human(id++, "Кожедуб Татьяна Ивановна", 1965, Gender.Female, h_1, h_2);
    Human h_6 = new Human(id++, "Кожедуб Константин Павлович", 1963, Gender.Male, h_3, h_4);
    Human h_7 = new Human(id++, "Кожедуб Владимир Павлович", 1988, Gender.Male, h_5, h_6);
    Human h_8 = new Human(id++, "Кожедуб Светлана Павловна", 1985, Gender.Female, h_5, h_6);
    List<Human> humans = new ArrayList<>(Arrays.asList(h_1, h_2, h_3, h_4, h_5, h_6, h_7, h_8 ));

    for (Human human : humans) {
      familyTree.getFamilyTree().add(human);
      if (human.getMother() != null) {
        human.getMother().addChild(human);
      }
      if (human.getFather() != null) {
        human.getFather().addChild(human);
      }
    }
  }
}
