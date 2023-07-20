package Homework;

//import Homework.model.Human.DeathHuman;
import Homework.model.Human.Gender;
import Homework.model.Human.Human;
import Homework.model.Tree.FamilyTree;
import Homework.model.Tree.FileMethods.FileMethods;
import Homework.view.ConsoleUI;
import Homework.view.View;

import java.io.IOException;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        FamilyTree familyTree = new FamilyTree();
//
//        Human human1 = new Human("Смирнова В.Г.", Gender.Female, LocalDate.of(1956, 11, 11));
//        Human human2 = new Human("Смирнов А.В.", Gender.Male, LocalDate.of(1936, 7, 1), LocalDate.of(1996, 7, 12));
//        Human human3 = new Human("Иванова Б.П.", Gender.Female, LocalDate.of(1955, 3, 8), LocalDate.of(2013, 10, 10));
//        Human human4 = new Human("Колесников П.П.", Gender.Male, LocalDate.of(1954, 1, 1));
//        Human human5 = new Human("Смирнов В.А.", Gender.Male, LocalDate.of(1985, 9, 30), human2, human1);
//        Human human6 = new Human("Смирнов В.В.", Gender.Male, LocalDate.of(2010, 5, 27), human5);
//        Human human7 = new Human("Колесникова А.А.", Gender.Female, LocalDate.of(1983, 12, 19),  human2, human1);
//        Human human8 = new Human("Колесников И.П.", Gender.Male, LocalDate.of(1980, 4, 17), human4, human3);
//        Human human9 = new Human("Колесников В.И.", Gender.Male, LocalDate.of(1999, 6, 2), human8, human7);
//        Human human10 = new Human("Колесникова А.И.", Gender.Female, LocalDate.of(2002, 9, 30), human8, human7);
//        Human human11 = new Human("Колесникова Е.И.", Gender.Female, LocalDate.of(2007, 4, 1), human8, human7);
//
//        familyTree.addHuman(human1);
//        familyTree.addHuman(human2);
//        familyTree.addHuman(human3);
//        familyTree.addHuman(human4);
//        familyTree.addHuman(human5);
//        familyTree.addHuman(human6);
//        familyTree.addHuman(human7);
//        familyTree.addHuman(human8);
//        familyTree.addHuman(human9);
//        familyTree.addHuman(human10);
//        familyTree.addHuman(human11);
//
//        System.out.println(familyTree.getHumanInfo());
//        System.out.println("=".repeat(20));
//        System.out.println();
//
//        System.out.println(familyTree.getByName("Колесникова Е.И."));
//        System.out.println("=".repeat(20));
//
//        //Метод поиска детей со всей информацией о них
//        System.out.println(human1.getChildren());
//        System.out.println("=".repeat(20));
//
//        //Метод поиска детей с выводом имени и возраста
//        System.out.println(human1.getChildAndAge());
//        System.out.println("-".repeat(20));
//
//        System.out.println(human5.getChildAndAge());
//        System.out.println("-".repeat(20));
//
//        System.out.println(human11.getChildAndAge());
//        System.out.println("=".repeat(20));
//
//
//        familyTree.getBrotherInfo(human10);
//        System.out.println("-".repeat(20));
//        familyTree.getBrotherInfo(human1);
//        System.out.println("=".repeat(20));
//
//        System.out.println("Бабушка и дедушка " + human6.getName() + ":");
//        System.out.println(human6.getGrandsInfo());
//        System.out.println("-".repeat(20));
//
//        System.out.println("Бабушка и дедушка " + human9.getName() + ":");
//        System.out.println(human6.getGrandsInfo());
//        System.out.println("-".repeat(20));
//
//        System.out.println("Бабушка и дедушка " + human8.getName() + ":");
//        System.out.println(human6.getGrandsInfo());
//        System.out.println("=".repeat(20));
//
//        FileMethods fileMethods = new FileMethods();
//
//        fileMethods.saveAllInFile(familyTree, "src/Homework/FamilyTree.out");
//        FamilyTree tree = (FamilyTree) fileMethods.read("src/Homework/FamilyTree.out");
//        System.out.println(tree.getHumanInfo());
//        System.out.println("=".repeat(20));
//
////        familyTree.sortByAge();
////        System.out.println("Сортировка по возрасту: ");
////        System.out.println(familyTree.getHumanInfo());
////        System.out.println("-".repeat(20));
////
////        System.out.println("Сортировка по имени: ");
////        familyTree.sortByName();
////        System.out.println(familyTree.getHumanInfo());
////        System.out.println("-".repeat(20));
////
////        familyTree.sortByChildren();
////        System.out.println("Сортировка по количеству детей: ");
////        System.out.println(familyTree.getHumanInfo());
////        System.out.println("=".repeat(20));

        View view = new ConsoleUI();
        view.start();


    }
}