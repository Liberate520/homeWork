package ru.gb.family_tree;


import ru.gb.family_tree.model.TreeService;
import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.filehandler.FileHandlerForTree;
import ru.gb.family_tree.model.filehandler.firstsave.FileHandler;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        FamilyTree<Human> tree = new FamilyTree<>();
//
//        Human petya = new Human("Петр", Gender.Male, LocalDate.of(1973, 11, 15));
//        Human olya = new Human("Ольга", Gender.Female, LocalDate.of(1975, 7, 20));
//        tree.add(petya);
//        tree.add(olya);
//        tree.setWedding(petya, olya);
//
//        Human katya = new Human("Екатерина", Gender.Female, LocalDate.of(1995, 9, 9),
//                petya, olya);
//        Human kolya = new Human("Николай", Gender.Male, LocalDate.of(1998, 3, 25),
//                petya, olya);
//        tree.add(katya);
//        tree.add(kolya);
//
//        Human ivan = new Human("Иван", Gender.Male, LocalDate.of(1952, 2, 5));
//        ivan.addChild(olya);
//        tree.add(ivan);
//
//        Human vika = new Human("Виктория", Gender.Female, LocalDate.of(1945,9,1));
//        vika.addChild(petya);
//        tree.add(vika);
//
//        System.out.println(tree);

        TreeService service = new TreeService(tree);
        service.setWritable(new FileHandlerForTree());
        service.write();

        View view = new ConsoleUI();
        view.start();
    }
}