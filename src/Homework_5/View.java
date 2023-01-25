package Homework_5;


import static javax.swing.JOptionPane.showMessageDialog;


import Print.InterfacePrint;
import Print.PrintTree;
import metods.PrintMetods;
import metods.SearchEngines;
import metods.SortClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class View extends SearchEngines {

    Scanner iScanner = new Scanner(System.in);

    Designer_Human designer_human;
    Femily_Tree femily_tree;
    SortClass sortClass;
    PrintMetods printMetods;


    public void showAll() {
        //Отображение сообщения в диалоговом окне
        showMessageDialog(null, """ 
                Добро пожаловать в программу генеалогическова древа
                              Выберете действие
                                
                                1.Добавить пользователя
                                2.Добавить пользователя с Id
                                3.Добавить детей
                                4.Добавить родителей
                                5.Показать все древо
                                6.Поиск по имени
                                7.Сортировка
                """);
        System.out.println("""
                Добро пожаловать в программу генеалогическова древа
                Выберете действие

                1.Добавить пользователя
                2.Добавить пользователя с Id
                3.Добавить детей
                4.Добавить родителей
                5.Показать все древо
                6.Поиск по имени
                7.Сортировка
                """);
        int choice = iScanner.nextInt();
        try {
            switch (choice) {
                case 1 -> femily_tree.addHumanNewHomework5(designer_human);
                case 2 -> femily_tree.addingPeopleWithAnIdScanner();
                case 3 -> showAllСhildren();
                case 4 -> showAllTree();
                case 5 -> searchHuman((ArrayList<Designer_Human>) designer_human.getHumans());
                case 6 -> showAllSorting();
                case 7 -> sortClass.sortingTheSheet();
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            showMessageDialog(null, "Промазал давай по новой ");
//            System.out.println("Промазал давай по новой ");

        }
    }

    /*
    Не используемые варианты реализации методов
     */

    /**
     * Варианты вариантов вывода древа
     */
//    private void showAllTree() {
//        System.out.println("Показать все древо");
//        System.out.println("Вариант № 1 ");
//        printMetods.ShowALL(designer_human.getHumans()); //Вариант 1
//        System.out.println("Вариант № 2 ");
//        printMetods.printFamilyTree(femily_tree); //Вариант 2
//        System.out.println("Вариант № 2 ");
//        printMetods.printTheTreeForEach(); //Вариант 3
//        printMetods.printDrevo((List<Designer_Human>) designer_human);
//    }
    private void showAllTree() {

        printMetods.ShowALL(designer_human.getHumans()); //Вариант 1
        System.out.println("Вариант № 2 ");
        printMetods.printFamilyTree(Collections.singletonList(femily_tree)); //Вариант 2
        System.out.println("Вариант № 2 ");
        printMetods.printTheTreeForEach(); //Вариант 3
        printMetods.printDrevo(designer_human);

        InterfacePrint print = new PrintTree();
        print.printTree();
    }

    /**
     * варианты добавления детей
     */
    private void showAllСhildren() {
        femily_tree.addChildren();
        femily_tree.addChildrenScanner();
        femily_tree.selectChildrenScanner();


    }

    /**
     * варианты поисковиков
     */
    public void showAllSorting() {
        searchHuman((ArrayList<Designer_Human>) designer_human.getHumans());
        showName();
    }

}

