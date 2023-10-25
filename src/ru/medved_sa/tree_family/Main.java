package ru.medved_sa.tree_family;

import ru.medved_sa.tree_family.familyTree.FamilyTree;
import ru.medved_sa.tree_family.human.Gender;
import ru.medved_sa.tree_family.human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree("New");

        Human oleg = new Human("Олег", Gender.Male,
                LocalDate.of(1988, 3, 5));
        Human irina = new Human("Ирина", Gender.Female,
                LocalDate.of(1993, 12, 11));

        System.out.println(oleg.toString());

        Human varvara = new Human("Кристина", Gender.Female,
                LocalDate.of(2020, 6, 15), oleg, irina);
        Human evgeniy = new Human("Евгений", Gender.Male,
                LocalDate.of(2018, 5, 12), oleg, irina);

        familyTree.addHuman(oleg);
        familyTree.addHuman(oleg); // Выдает сообщение о не возможности добавить человека.
        familyTree.addHuman(irina);

//        familyTree.setWedding(oleg.getId(), irina.getId());
        familyTree.setWedding(oleg, irina);


        familyTree.addHuman(varvara);
        familyTree.addHuman(evgeniy);

        Human larisa = new Human("Лариса", Gender.Female,
                LocalDate.of(1955, 9, 1));

        larisa.addChild(oleg);

        System.out.println(larisa);
        familyTree.addHuman(larisa);

        System.out.println(familyTree);


        System.out.println(oleg.getFindInfoAboutChildren());
        System.out.println(oleg.getBirthDate());
        System.out.println(evgeniy.getFindMotherName());
        System.out.println(evgeniy.getFindFatherName());
        System.out.println(evgeniy.getFather());
        System.out.println(larisa.getAge());
        System.out.println(familyTree.getById(4));
        System.out.println(familyTree.getSiblings(3));
        System.out.println(familyTree.getByFirstName(irina.getFirstName()));

    }
}
