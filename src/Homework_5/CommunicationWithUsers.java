package Homework_5;

import metods.PrintMetods;
import metods.SortClass;

import java.util.ArrayList;
import java.util.Scanner;

public class CommunicationWithUsers {
    //
    Scanner iScanner = new Scanner(System.in);
//    Femily_Tree femily_tree = new Femily_Tree();//Экземпляр класса
    Femily_Tree femily_tree;
//    Service service = new Service(femily_tree);
PrintMetods printMetods;

    SortClass sortClass;
    Designer_Human designer_human;


    /**
     * Вызов класса общения с пользователем.
     */
    public void selectTheProgramVersion() {
        System.out.println("""
                Выберете версию программы
                1.Старая версия
                2.Новая версия""");
        int choice = iScanner.nextInt();
        try {
            switch (choice) { //при одной функции на case очень удобная и красивая запись
                case 1 -> showAllOld();
                case 2 -> showAllNew();
            }
//            System.out.println("Промазал давай по новой ");
//            selectTheProgramVersion();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Промазал давай по новой ");
            selectTheProgramVersion();
        }
    }


    /**
     * @parm Более топорная версия(Тут все действия находятся в switch)
     */
    public void showAllOld() {
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
                case 1: //вариант добавления
                    String choiceName = iScanner.nextLine();
                    String choiceGender = iScanner.nextLine();
                    int choiceDate = iScanner.nextInt();
//                Designer_Human.addHuman(choiceName, choiceGender, choiceDate);
                    //IDEA на этом этапе предлагает статику а в самом методе предлагает убрать статику.
                    femily_tree.addHumanSimple(new Designer_Human(choiceName, choiceGender, choiceDate));
                    break;
                case 2:
                    String choiceNameId = iScanner.nextLine();
                    String choiceGenderId = iScanner.nextLine();
                    int choiceDateId = iScanner.nextInt();
                    femily_tree.addingPeopleWithAnId(choiceNameId, choiceGenderId, choiceDateId);
                    break;

                case 3:
                    System.out.println("Кто твои родители?");
                    printMetods.printDrevo(designer_human.getHumans());
                    femily_tree.addChildren(); //старый вариант добавления
                    Femily_Tree.selectChildrenScanner(); // Новый вариант добавления детей

                case 4:
                    System.out.println("К кому будем добавлять родителей ?");
                    printMetods.printDrevo(designer_human.getHumans());
                /*
                тут нужно получить список людей
                Разбить их на числа с помощью hushMap
                и сделать выбор по некой id а пока это значение null
                 */
                /*
                Нужно полностью переделать метод.
                На вход получал не объект класса а строку для записи.
                String choiceFather = iScanner.nextLine();
                String choiceMother = iScanner.nextLine();
                femily_tree.addParents(null,choiceFather,choiceMother);

                 */

                case 5:
                    System.out.println("Показать все древо");
                    printMetods.ShowALL(designer_human.getHumans()); //Вариант 1
                    printMetods.printTheTreeForEach(); //Вариант 2
                    break;
                case 6:
                    System.out.println("Введите имя");
                    String choiceNameCase5 = iScanner.nextLine();
                    femily_tree.showName(choiceNameCase5);
                    break;
                case 7:
                    sortClass.sortingTheSheet();
                    break;


            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Промазал давай по новой ");
            selectTheProgramVersion();
        }
    }

    /**
     * меню сортировки
     */

    /**
     * @parm В этой версии происходит только вызовы методов(Все действия в самих методах)
     * не закончил.
     */
    public void showAllNew() {
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
        /*

         */
        int choice = iScanner.nextInt();
        try {
            switch (choice) {
                case 1 -> {
                    femily_tree.addHumanNewHomework4(designer_human);
                }
                case 2 -> {
                    femily_tree.addingPeopleWithAnIdScanner();
                }
                case 3 -> {
                    Femily_Tree.selectChildrenScanner();

                }

                case 4 -> {
                    System.out.println("Показать все древо");
                    printMetods.ShowALL(designer_human.getHumans()); //Вариант 1
                    printMetods.printFamilyTree(femily_tree); //Вариант 2
                    printMetods.printTheTreeForEach(); //Вариант 3
                }


                case 5 -> {//поиск по имени
                    femily_tree.searchHuman((ArrayList<Designer_Human>) designer_human.getHumans());
                }
                case 6 -> {

                }
                case 7 -> {
                    sortClass.sortingTheSheet();
                }

            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Промазал давай по новой ");
            selectTheProgramVersion();

        }
    }

}


