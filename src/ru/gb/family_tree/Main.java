package ru.gb.family_tree;


import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = testTree();
        System.out.println(tree);
    }

    static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();

        Human petya = new Human("Петр", Gender.Male, LocalDate.of(1973, 11, 15));
        Human olya = new Human("Ольга", Gender.Female, LocalDate.of(1975, 7, 20));
        tree.add(petya);
        tree.add(olya);
        tree.setWedding(petya, olya);

        Human katya = new Human("Екатерина", Gender.Female, LocalDate.of(1995, 9, 9),
                petya, olya);
        Human kolya = new Human("Николай", Gender.Male, LocalDate.of(1998, 3, 25),
                petya, olya);
        tree.add(katya);
        tree.add(kolya);

        Human ivan = new Human("Иван", Gender.Male, LocalDate.of(1952, 2, 5));
        ivan.addChild(olya);
        tree.add(ivan);

        Human vika = new Human("Виктория", Gender.Female, LocalDate.of(1945,9,1));
        vika.addChild(petya);
        tree.add(vika);

        return tree;
    }
}