package ru.gb.family_tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        LocalDate birthday1 = LocalDate.of(1990, 5, 20);
        Human Sergey = new Human("Sergey", birthday1, Gender.Male);
        familyTree.addMember(Sergey);
//        Sergey.getAge();
//        Sergey.getGender();
        LocalDate birthday2 = LocalDate.of(2015, 2, 15);
        Human Sasha = new Human("Sasha", birthday2, Gender.Female);
        familyTree.addMember(Sasha);
        LocalDate birthday3 = LocalDate.of(2015, 2, 15);
        Human Ivan = new Human("Ivan", birthday3, Gender.Male);
        familyTree.addMember(Ivan);
//        Sasha.getAge();
        Sergey.setChildren(Sasha);
        Sergey.setChildren(Ivan);
//        Sergey.printChildren();
        LocalDate birthday4 = LocalDate.of(1970, 3, 18);
        Human Yulia = new Human("Yulia", birthday4, Gender.Female);
        familyTree.addMember(Yulia);
        LocalDate birthday5 = LocalDate.of(1971, 6, 3);
        Human Daniil = new Human("Daniil", birthday5, Gender.Male);
        familyTree.addMember(Daniil);
        Sergey.setMother(Yulia);
        Sergey.setFather(Daniil);
//        Sergey.getFather();
//        familyTree.printMember();
        Yulia.printChildren();
    }
}
