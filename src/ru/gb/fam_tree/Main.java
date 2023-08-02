package ru.gb.fam_tree;

import ru.gb.fam_tree.family_tree.FamilyTree;
import ru.gb.fam_tree.human.Gender;
import ru.gb.fam_tree.human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = testTree();
        //сортировка по айди(ну я думаю, что ее можно не счтитать, т.к. она записывается в таком проядке)
        System.out.println(tree);

        //сортирвока по возрасту
        tree.sortByAge();
        System.out.println(tree);

        //сортировка по имени
        tree.sortByName();
        System.out.println(tree);
    }

    static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();
        Human masha = new Human ("Maria", Gender.Female, LocalDate.of(1965,9,15));
        Human vasya = new Human ("Vasiliy", Gender.Male, LocalDate.of(1963,12,10));
        tree.add(vasya);
        tree.add(masha);
        tree.setWedding(vasya,masha);

        Human christina = new Human("Kristina", Gender.Female, LocalDate.of(1988, 7,5),
                vasya,masha);
        Human semyon = new Human("Semyon", Gender.Male, LocalDate.of(1991,1,25),
                vasya,masha);
        tree.add(christina);
        tree.add(semyon);

        Human larisa = new Human("Larisa", Gender.Female, LocalDate.of(1945,9,1));
        larisa.addChild(vasya);
        tree.add(larisa);

        return tree;
    }
}
