package ru.gb.family_tree;

import java.io.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "src/ru/gb/family_tree/tree.out";
        FileHandler fileHandler = new FileHandler();
        FamilyTree tree = new FamilyTree();
//        fileHandler.save(tree, filePath);

//        FamilyTree tree = (FamilyTree) fileHandler.read(filePath);
//        System.out.println(tree);

        tree.addHuman(new Human("Ivanov Ivan Petrovich", Gender.Male, LocalDate.of(1938,10,23), null, null, null));
        tree.addHuman(new Human("Ivanov Petr Sergeevich", Gender.Male, LocalDate.of(1958, 2, 12),null, tree.getByFullName("Ivanov Ivan Petrovich"), null));
        tree.addHuman(new Human("Ivanova Inna Vasil'evna", Gender.Female, LocalDate.of(1960,9,3),null, null, null));
        tree.addHuman(new Human("Ivanov Sergey Petrovich", Gender.Male, LocalDate.of(1982,5,30),null, tree.getByFullName("Ivanov Petr Sergeevich"), tree.getByFullName("Ivanova Inna Vasil'evna")));

        System.out.println(tree.getInfo());
        tree.sortByFullName();
        System.out.println(tree.getInfo());
        tree.sortByAge();
        System.out.println(tree.getInfo());

    }
}
