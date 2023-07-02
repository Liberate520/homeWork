package ru.gb.FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human("Ivanov Ivan Petrovich", Gender.Male, LocalDate.of(1938,10,23), null, null, null);
        Human human2 = new Human("Ivanov Petr Sergeevich", Gender.Male, LocalDate.of(1958, 2, 12),null, familyTree.getByPerson("Ivanov Ivan Petrovich"), null);
        Human human3 = new Human("Ivanova Inna Vasil'evna", Gender.Female, LocalDate.of(1960,9,3),null, null, null);
        Human human4 = new Human("Ivanov Sergey Petrovich", Gender.Male, LocalDate.of(1982,5,30),null, familyTree.getByPerson("Ivanov Petr Sergeevich"), familyTree.getByPerson("Ivanova Inna Vasil'evna"));

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);

        System.out.println(familyTree.getInfo());

    }
}
