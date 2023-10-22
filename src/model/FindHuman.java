package model;

import java.util.Scanner;

import model.human.Human;

public class FindHuman {
   private FamilyTree<Human> familyTree;
   private Scanner scanner;

   public FindHuman(FamilyTree<Human> familyTree) {
      this.familyTree = familyTree;
      this.scanner = new Scanner(System.in);
   }

   void getHumanByName() {
      System.out.println("Введите фамилию, имя, отчество через запятую: ");
      try {
         String name = scanner.next();
         Human human = familyTree.getHumanByName(name);
         if (human == null) {
            System.out.println("По введённому имени в дереве родственников не нашлось");
         } else {
            int countChildren = human.getChildren().size();
            String textAboutChildren = "детей нет";
            if (countChildren > 0) {
               StringBuilder stringBuilder = new StringBuilder("дети: \n");
               stringBuilder.append("");
               for (int i = 0; i < countChildren; i++) {
                  stringBuilder.append(human.getChildren().get(i).toString());
               }
               textAboutChildren = stringBuilder.toString();
            }
            System.out.printf("По введённому имени найден сдедующий родственник: \n %s %s \n",
                  human.toString(), textAboutChildren);
         }
      } catch (Exception e) {
         System.out.println("Ошибка ввода параметров поиска!" + e);
      }
   }
}
