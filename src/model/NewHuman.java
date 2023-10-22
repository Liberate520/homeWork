package model;

import java.util.Scanner;

import model.human.Human;

class NewHuman{
   private FamilyTree<Human> familyTree;
   private Scanner scanner;

   NewHuman(FamilyTree<Human> familyTree){
      this.familyTree = familyTree;
      this.scanner = new Scanner(System.in);
   }
   Human readNewHuman(){
      try {
         System.out.println("Для добавления в список вводите через запятую без пробелов: \n"+ 
         "фамилия, имя, отчество, пол (м или ж), id отца, id матери (если есть, иначе -1), год рождения");
         String humanForAdding = scanner.next();
         String[] arrayDataOfHuman = humanForAdding.split("[,]");

         String nameFull = String.format("%s %s %s", arrayDataOfHuman[0], arrayDataOfHuman[1], 
         arrayDataOfHuman[2]);
         Human father = familyTree.getHumanById(Integer.parseInt(arrayDataOfHuman[4]));
         Human mother = familyTree.getHumanById(Integer.parseInt(arrayDataOfHuman[5]));
         int birthDate = Integer.parseInt(arrayDataOfHuman[6]);
         int id = familyTree.getLastId() + 1;
         return new Human(id, nameFull, birthDate, familyTree.getGender(arrayDataOfHuman[3]), father, mother);
   } catch (Exception e){
      System.out.println("Ошибка ввода!" + e);
   }
   return null;
   }

 }
