package ru.gb.family_tree;

import ru.gb.family_tree.Servise.FileHandler;
import ru.gb.family_tree.Servise.TestData;
import ru.gb.family_tree.Tree.FamilyTree;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileHandler fileHandler = new FileHandler();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-----------------------");
            System.out.println("Введите:\n p - вывести инф. о дереве;\n" +
                    " s - сортировка по имени;\n" +
                    " a - сортировка по возрасту;\n" +
                    " b - сортировка по дате рождения;\n" +
                    " с - выполнить сериализацию проекта;\n" +
                    " d - десериализация проекта;\n" +
                    " q - выход.\n");
            String data = scanner.nextLine();
            if (data.equalsIgnoreCase("p")) {
                FamilyTree familyTree = TestData.testData();
                System.out.println(familyTree.getTreeInfo());
            } else if (data.equalsIgnoreCase("s")) {
                FamilyTree familyTree = TestData.testData();
                System.out.println("Сортировка по имени >>>>>> ");
                familyTree.sortByName();
                System.out.println(familyTree.getTreeInfo());
            } else if (data.equalsIgnoreCase("a")) {
                FamilyTree familyTree = TestData.testData();
                System.out.println("Сортировка по возрасту >>>>>>  ");
                familyTree.sortByAge();
                System.out.println(familyTree.getTreeInfo());
            } else if (data.equalsIgnoreCase("b")) {
                FamilyTree familyTree = TestData.testData();
                System.out.println("Сортировка по дате рождения >>>>>>  ");
                familyTree.sortByBirthday();
                System.out.println(familyTree.getTreeInfo());
            } else if (data.equalsIgnoreCase("c")) {
                FamilyTree familyTree = TestData.testData();
                fileHandler.save(familyTree, "src/ru/gb/family_tree/tree.out");
                System.out.println("экспорт (tree.out) завершен успещно");}
            else if(data.equalsIgnoreCase("d")) {
                FamilyTree familyTree = (FamilyTree) fileHandler.loading("src/ru/gb/family_tree/tree.out");
                System.out.println("Импорт данных выполнен: " + familyTree);}
            else if (data.equalsIgnoreCase("q")) System.exit(0);
        }
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
