package ru.gb.family_tree;

import ru.gb.family_tree.model.servise.FileHandler;
import ru.gb.family_tree.model.servise.TestData;
import ru.gb.family_tree.model.tree.FamilyTree;
import ru.gb.family_tree.view.ConsoleView;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ConsoleView consoleView = new ConsoleView();
        consoleView.start();
    }
}












































//        Human human1 = new Human("1DWG10", "Сафронов", "Николай", Male, LocalDate.of(2005, 05, 20),
//                null, "Сафронова МАРИЯ", "Сафронов Михаил");
//
//        Human human2 = new Human("246H10", "Сафронова", "Елена", Female, LocalDate.of(2010, 10, 10),
//                null, "Сафронова МАРИЯ", "Сафронов Михаил");
//
//        Human human4 = new Human("4А5810", "САФРОНОВА", "ЕКАТЕРИНА", Female, LocalDate.of(1982, 10, 20),
//                null, "САФРОНОВ АЛЕКСЕЙ", "ЕжовА МариЯ", "ЕжоВ НиколаЙ", null);
//
//        Human human3 = new Human("145G10", "САФРОНОВ", "АЛЕКСЕЙ", Male, LocalDate.of(1978, 11, 21),
//                null, "САФРОНОВА ЕКАТЕРИНА", "СафроновА МариЯ", "СафроноВ НиколаЙ", null);
//
//        Human human5 = new Human("RT473G", "ЕжовА", "МариЯ", Female, LocalDate.of(1958, 11, 21),
//                null, "ЕжоВ НиколаЙ", "Буча Елена", "Буча Иван", null);
//
//        Human human6 = new Human("SD473G", "ЕжоВ", "НиколаЙ",Male, LocalDate.of(1964, 3, 21),
//                LocalDate.of(2017, 9, 14), "ЕжовА МариЯ", "Ежова Надежда", "Ежов Константин", null);
//
//        Human human7 = new Human("DH473G", "СафроновА", "МариЯ", Female, LocalDate.of(1964, 3, 21),
//                null, "Сафронов НиколаЙ", "Потемкина Екатерина", "Потемкин Густав", null);
//
//        familyTree.addHuman(new Human("DG73G", "СафроноВ", "НиколаЙ", Male, LocalDate.of(1952, 11, 21),
//                null, "Сафронова МариЯ", "Сафронова Лидия", "Сафронов Костантин", null));
