package ru.gb.family_tree;

import ru.gb.family_tree.familytree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.time.LocalDate;


public class Main {
    public static void main(String [] args){
        FamilyTree familyTree = new FamilyTree(0);


        Human human1 = new Human("Рикорд", LocalDate.of(1949,10,20),LocalDate.of(1980,01,15), Gender.Male);
        familyTree.addHuman(human1);

        Human human2 = new Human("Брендон",LocalDate.of(1968,9,10),Gender.Male);
        familyTree.addHuman(human2);

        Human human3 = new Human("Бенджен",LocalDate.of(1972,10,13),LocalDate.of(1990,3,21),Gender.Male);
        familyTree.addHuman(human3);
        Human human4 = new Human("Лиана",LocalDate.of(1965,7,10),LocalDate.of(1987,10,7),Gender.Female);
        familyTree.addHuman(human4);
        Human human5 = new Human("Эддард",LocalDate.of(1970,2,13),Gender.Male);
        familyTree.addHuman(human5);
        Human human6 = new Human("Кейтилин",LocalDate.of(1971,10,3),Gender.Female);
        familyTree.addHuman(human6);
        Human human7 = new Human("Санса",LocalDate.of(1991,9,3),Gender.Female);
        familyTree.addHuman(human7);
        Human human8 = new Human("Арья",LocalDate.of(1997,7,4),Gender.Female);
        familyTree.addHuman(human8);
        Human human9 = new Human("Бран",LocalDate.of(2000,8,1),Gender.Male);
        familyTree.addHuman(human9);

        human1.addChild(human2);
        human1.addChild(human3);
        human1.addChild(human4);
        human1.addChild(human5);
        human2.addParent(human1);
        human3.addParent(human1);
        human4.addParent(human1);
        human5.addParent(human1);
        human5.addChild(human7);
        human5.addChild(human8);
        human5.addChild(human9);
        human6.addChild(human7);
        human6.addChild(human8);
        human6.addChild(human9);
        human7.addParent(human5);
        human7.addParent(human6);
        human8.addParent(human5);
        human8.addParent(human6);
        human9.addParent(human5);
        human9.addParent(human6);

        System.out.println(familyTree.getInfo());
        /*
        FileHandlerForTree fileHandlerForTree=new FileHandlerForTree();
        fileHandlerForTree.save(familyTree,"src/ru/gb/family_tree/familyTree.out");
        familyTree = (FamilyTree) fileHandlerForTree.read("src/ru/gb/family_tree/familyTree.out");
        System.out.println(familyTree.getInfo());
        */

        familyTree.sortByName();
        System.out.println(familyTree.getInfo());
        familyTree.sortByAge();
        System.out.println(familyTree.getInfo());

    }
}
