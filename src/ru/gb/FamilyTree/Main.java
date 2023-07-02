package ru.gb.FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        tree.addHuman(new Human("Ivanov Ivan Petrovich", Gender.Male, LocalDate.of(1938,10,23), null, null, null));
        tree.addHuman(new Human("Ivanov Petr Sergeevich", Gender.Male, LocalDate.of(1958, 2, 12),null, tree.getByFullName("Ivanov Ivan Petrovich"), null));
        tree.addHuman(new Human("Ivanova Inna Vasil'evna", Gender.Female, LocalDate.of(1960,9,3),null, null, null));
        tree.addHuman(new Human("Ivanov Sergey Petrovich", Gender.Male, LocalDate.of(1982,5,30),null, tree.getByFullName("Ivanov Petr Sergeevich"), tree.getByFullName("Ivanova Inna Vasil'evna")));

        System.out.println(tree.getInfo());

    }
}
