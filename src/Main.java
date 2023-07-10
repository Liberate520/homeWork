package ru.gb.family_tree;

import java.time.LocalDate;
import java.util.List;

import static java.util.List.of;

public class Main {
    public static void main(String [] args){
        FamilyTree familyTree = new FamilyTree(0);
       /*
        Human human1 = new Human("Рикорд", LocalDate.of(1949,10,20),LocalDate.of(1980,01,15),Gender.Male);
        Human human2 = new Human("Брендон",LocalDate.of(1968,9,10),Gender.Male,List.of(human1.getName(), "Леди Финт"));
        Human human3 = new Human("Бенджен",LocalDate.of(1972,10,13),LocalDate.of(1990,3,21),Gender.Male,List.of(human1.getName(), "Леди Финт"));
        Human human4 = new Human("Лиана",LocalDate.of(1965,7,10),LocalDate.of(1987,10,7),Gender.Female, List.of(human1.getName(), "Леди Финт"));
        Human human5 = new Human("Эддард",LocalDate.of(1970,2,13),Gender.Male, List.of(human1.getName(), "Леди Финт"));
        Human human6 = new Human("Кейтилин",LocalDate.of(1971,10,3),Gender.Female);
        Human human7 = new Human("Санса",LocalDate.of(1991,9,3),Gender.Female, List.of(human5.getName(),human6.getName()));
        Human human8 = new Human("Арья",LocalDate.of(1997,7,4),Gender.Female, List.of(human5.getName(),human6.getName()));
        Human human9 = new Human("Бран",LocalDate.of(2000,8,1),Gender.Male,List.of(human5.getName(),human6.getName()));
        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);
        familyTree.addHuman(human7);
        familyTree.addHuman(human8);
        familyTree.addHuman(human9);
        */
        Human human1 = new Human("Рикорд", LocalDate.of(1949,10,20),LocalDate.of(1980,01,15),Gender.Male);
        familyTree.addHuman(human1);
        Human human2 = new Human("Брендон",LocalDate.of(1968,9,10),Gender.Male, List.of(human1, "Леди Финт"));
        familyTree.addHuman(human2);
        Human human3 = new Human("Бенджен",LocalDate.of(1972,10,13),LocalDate.of(1990,3,21),Gender.Male, of(human1.getName(), "Леди Финт"));
        familyTree.addHuman(human3);
        Human human4 = new Human("Лиана",LocalDate.of(1965,7,10),LocalDate.of(1987,10,7),Gender.Female, of(human1.getName(), "Леди Финт"));
        familyTree.addHuman(human4);
        Human human5 = new Human("Эддард",LocalDate.of(1970,2,13),Gender.Male, of(human1.getName(), "Леди Финт"));
        familyTree.addHuman(human5);
        Human human6 = new Human("Кейтилин",LocalDate.of(1971,10,3),Gender.Female);
        familyTree.addHuman(human6);
        Human human7 = new Human("Санса",LocalDate.of(1991,9,3),Gender.Female, of(human5.getName(),human6.getName()));
        familyTree.addHuman(human7);
        Human human8 = new Human("Арья",LocalDate.of(1997,7,4),Gender.Female, of(human5.getName(),human6.getName()));
        familyTree.addHuman(human8);
        Human human9 = new Human("Бран",LocalDate.of(2000,8,1),Gender.Male, of(human5.getName(),human6.getName()));
        familyTree.addHuman(human9);


        System.out.println(familyTree.getHumanInfo());
    }
}
