package ru.medved_sa.tree_family;

import ru.medved_sa.tree_family.familyTree.FamilyTree;
import ru.medved_sa.tree_family.human.Gender;
import ru.medved_sa.tree_family.human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        FamilyTree first = new FamilyTree("New");

        Human oleg = new Human("Олег", Gender.Male,
                LocalDate.of(1988, 3, 5));
        Human irina = new Human("Ирина", Gender.Female,
                LocalDate.of(1993, 12, 11));

        System.out.println(oleg.toString());

        Human varvara = new Human("Кристина", Gender.Female,
                LocalDate.of(2010, 6, 15), oleg, irina);
        Human evgeniy = new Human("Евгений", Gender.Male,
                LocalDate.of(2015, 5, 12), oleg, irina);

        first.addHuman(oleg);
        first.addHuman(irina);
        first.addHuman(varvara);
        first.addHuman(evgeniy);

        System.out.println(first.toString());


        System.out.println(oleg.getFindInfoAboutChildren());
        System.out.println(oleg.getBirthDate());
        System.out.println(evgeniy.getFindMotherName());
        System.out.println(evgeniy.getFindFatherName());
        System.out.println(evgeniy.getFather());

    }
}
