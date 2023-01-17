package Homework_5;

import metods.Designer_Human;
import metods.PrintMetods;
import metods.SortClass;

import java.util.ArrayList;
import java.util.Scanner;

public class View {

    Scanner iScanner = new Scanner(System.in);

    Designer_Human designer_human;
    Femily_Tree femily_tree;
    SortClass sortClass;
PrintMetods printMetods;

    public void showAll() {
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
                case 1 -> femily_tree.addHumanNewHomework4(designer_human);
                case 2 -> {}
                case 3 -> {}
                case 4 -> showAllTree();
                case 5 -> femily_tree.searchHuman((ArrayList<Designer_Human>) femily_tree.getTree());
                case 6 -> {}
                case 7 -> sortClass.sortingTheSheet();
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Промазал давай по новой ");

        }
    }

    /*
    Не используемые варианты реализации методов
     */

    /**
     * Варианты вариантов вывода древа
     */
    private void showAllTree(){
        System.out.println("Показать все древо");
        System.out.println("Вариант № 1 ");
        printMetods.showALL(femily_tree.getTree()); //Вариант 1
        System.out.println("Вариант № 2 ");
        printMetods.printFamilyTree(femily_tree); //Вариант 2
        System.out.println("Вариант № 2 ");
        printMetods.printTheTreeForEach(); //Вариант 3
    }

}

