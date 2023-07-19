package classes.view;

import classes.service.Service;

import java.util.Scanner;

public class MenuFast {

    public static void menu() {
        Scanner in = new Scanner(System.in);
        boolean cycle = true;

        while (cycle) {

//                System.out.println("Пока обычное меню (с настраиваемым еще не разбирался)");
            System.out.println("   МЕНЮ >>>> Введите код операции: (Пока обычное меню (с настраиваемым еще не разбирался))");
            System.out.println("   МЕНЮ >>>> 0 - ВЫХОД             1-Тестовый ввод через код в \"TestInput\"    2-Сохранение в файл        3-Загрузка из файла");
//                System.out.println("1-Тестовый ввод через код в \"TestInput\"");
//                System.out.println("2-Сохранение в файл");
//                System.out.println("3-Загрузка из файла");
            System.out.println("   МЕНЮ >>>> 4-вывод списка людей    5-сортировка по имени   6-сортировка по ID   7-сортировка по дате рождения ");
//                System.out.println("5-ввод персоны");
//                System.out.println("6-Добавить ребенка");
//                System.out.println("7-Добавить родителя");
            System.out.print("   МЕНЮ >>>> Вводим сюда>>>>>");
            String com = in.next();
            switch (com) {
                case ("0"): {
                    cycle = false;
                    break;
                }
                case ("1"): {
//                    TestInput.TestInput(tree);//Тестовый вариант заполнения списка;
                    Service.testInput();
                    break;
                }
                case ("2"): {
                    Service.saveTree();
                    //             fileGuide.save(tree, pathToTreeFile);
                    break;
                }
                case ("3"): {
                    Service.readTree();
                    //              tree = (FamilyTree) fileGuide.read(pathToTreeFile);
                    break;
                }
                case ("4"): {
                    Service.getTreeInfo();
//                    System.out.println(tree.getInfo());
//                    System.out.println("Список содержит записей: " + tree.humanList.size());
                    break;
                }
                case ("5"): {
                    Service.sortTreeByName();
                    //           tree.sortByName();
                    //           System.out.println(tree.getInfo());
                    break;
                }
                case ("6"): {
                    Service.sortTreeById();
                    //           tree.sortById();
                    //          System.out.println(tree.getInfo());
                    break;
                }
                case ("7"): {
                    Service.sortTreeByBrithDate();
                    //          tree.sortByBrithDate();
                    //          System.out.println(tree.getInfo());
                }
                default: {
                    System.out.println("Непонятная команда");
                    break;
                }
            }
//                cycle=false;

        }
    }
}


