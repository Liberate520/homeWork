package Homework;

import Homework.Human.DeathHuman;
import Homework.Human.Gender;
import Homework.Human.Human;
import Homework.Tree.FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human("Смирнова В.Г.", LocalDate.of(1956, 11, 11), Gender.Female);
        Human human2 = new DeathHuman("Смирнов А.В.", LocalDate.of(1936, 7, 1), LocalDate.of(1996, 7, 12), Gender.Male);
        Human human3 = new DeathHuman("Иванова Б.П.", LocalDate.of(1955, 3, 8), LocalDate.of(2013, 10, 10), Gender.Female);
        Human human4 = new Human("Колесников П.П.", LocalDate.of(1954, 1, 1), Gender.Male);
        Human human5 = new Human("Смирнов В.А.", LocalDate.of(1985, 9, 30), Gender.Male, human2, human1);
        Human human6 = new Human("Смирнов В.В.", LocalDate.of(2010, 5, 27), Gender.Male, human5);
        Human human7 = new Human("Колесникова А.А.", LocalDate.of(1983, 12, 19), Gender.Female, human2, human1);
        Human human8 = new Human("Колесников И.П.", LocalDate.of(1980, 4, 17), Gender.Male, human4, human3);
        Human human9 = new Human("Колесников В.И.", LocalDate.of(1999, 6, 2), Gender.Male, human8, human7);
        Human human10 = new Human("Колесникова А.И.", LocalDate.of(2002, 9, 30), Gender.Female, human8, human7);
        Human human11 = new Human("Колесникова Е.И.", LocalDate.of(2007, 4, 1), Gender.Female, human8, human7);

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);
        familyTree.addHuman(human7);
        familyTree.addHuman(human8);
        familyTree.addHuman(human9);
        familyTree.addHuman(human10);
        familyTree.addHuman(human11);

        System.out.println(familyTree.getHumanInfo());
        System.out.println("=".repeat(20));
        System.out.println();

        familyTree.getHuman("Колесникова Е.И.");
        System.out.println("=".repeat(20));


        familyTree.getChild("Смирнова В.Г.");
        System.out.println("=".repeat(20));
        familyTree.getChild("Смирнов В.А.");
        System.out.println("=".repeat(20));
        familyTree.getChild("Колесникова Е.И.");
    }
}