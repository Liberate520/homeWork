package ru.gb.family_tree;


import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.familytree.FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> tree = new FamilyTree<>();

        Human egor = new Human("Egor", Gender.Male, LocalDate.of(1990, 6, 15));
        Human valeria = new Human("Valeria", Gender.Female, LocalDate.of(1992, 7, 3));
        Human anna = new Human("Anna", Gender.Female, LocalDate.of(1973, 5, 6));
        Human denis = new Human("Denis", Gender.Male, LocalDate.of(1980, 10, 9));

        tree.addSub(egor);
        tree.addSub(valeria);
        tree.addSub(anna);
        tree.addSub(denis);

        Human ivan = new Human("Ivan", Gender.Male, LocalDate.of(1965, 12, 1), egor, valeria);
        Human ksenia = new Human("Ksenia", Gender.Female, LocalDate.of(1986, 5, 6), denis, anna);

        tree.addSub(ivan);
        tree.addSub(ksenia);

        Human grandMother = new Human("Natalya", Gender.Female, LocalDate.of(1970, 4, 6));
        grandMother.addChild(egor);

        tree.addSub(grandMother);

        System.out.println(tree);
    }
}

