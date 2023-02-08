package src.Service.Tree;

import src.Entities.FamilyTree;
import src.Entities.Human;

public class TreeFillData {

  public TreeFillData(FamilyTree<Human> familyTree) {
    Human ivanIvanov = new Human("Иван Иванов", "Мужской");
    Human mariaIvanova = new Human("Мария Иванова", "Женский");
    Human petrIvanov = new Human("Петр Иванов", "Мужской", mariaIvanova, ivanIvanov);

    familyTree.addHuman(ivanIvanov);
    familyTree.addHuman(mariaIvanova);
    familyTree.addHuman(petrIvanov);
  }
}
