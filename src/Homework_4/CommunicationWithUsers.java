package Homework_4;

import java.util.ArrayList;
import java.util.Scanner;

public class CommunicationWithUsers {
    //
    Scanner iScanner = new Scanner(System.in);

    Designer_Human designer_human = new Designer_Human();//Экземпляр класса
    Femily_Tree femily_tree = new Femily_Tree();//Экземпляр класса

    public void selectTheProgramVersion() {
        System.out.println("""
                Выберете версию программы
                1.Старая версия
                2.Новая версия""");
        int choice = iScanner.nextInt();
        switch (choice) {
            case 1:
                showAllOld();
                break;
            case 2:
                showAllNew();
                break;

        }
        System.out.println("Промазал давай по новой ");
        selectTheProgramVersion();
    }

    /**
     * @parm Более топорная версия(Тут все действия находятся в swith)
     */
    public void showAllOld() {
        System.out.println("""
                Добро пожаловать в программу генеалогическова древа
                Выберете действие

                1.Добавить пользователя
                2.Добавить детей
                3.Добавить родителей
                4.Показать все древо
                5.Поиск по имени""");
        int choice = iScanner.nextInt();
        switch (choice) {
            case 1: //вариант добавления
                String choiceName = iScanner.nextLine();
                String choiceGender = iScanner.nextLine();
                int choiceDate = iScanner.nextInt();
//                Designer_Human.addHuman(choiceName, choiceGender, choiceDate);
                //IDEA на этом этапе предлагает статику а в самом методе предлагает убрать статику.
                femily_tree.addHumansimple(new Designer_Human(choiceName,choiceGender,choiceDate));
                break;
            case 2:
                System.out.println("К кому будем добавлять детей ?");
                femily_tree.printDrevo(femily_tree.getTree());
                designer_human.addChildren();


            case 3:
                System.out.println("К кому будем добавлять родителей ?");
                femily_tree.printDrevo(femily_tree.getTree());
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

            case 4:
                System.out.println("Показать все древо");
                femily_tree.ShowALL(femily_tree.getTree());
                break;


            case 5:
                System.out.println("Введите имя");
                String choiceNameCase5 = iScanner.nextLine();
                femily_tree.showName(choiceNameCase5);
                break;


        }
    }

    /**
     * @parm В этой версии происходит только вызовы методов(Все действия в самих методах)
     */
    public void showAllNew() {
        System.out.println("""
                Добро пожаловать в программу генеалогическова древа
                Выберете действие
                                
                1.Добавить пользователя
                2.Добавить детей
                3.Добавить родителей
                4.Показать все древо
                5.Поиск по имени
                """);
        int choice = iScanner.nextInt();
        switch (choice) {
            case 1://На мой взгляд улучшенный вариант добавления(все действия прописаны в функции)
                femily_tree.addHumanNewHomework4(designer_human);
                break;
            case 2:
            case 3:
            case 4:
                System.out.println("Показать все древо");
                femily_tree.ShowALL(femily_tree.getTree()); //Вариант 1
                femily_tree.printFamilyTree(femily_tree); //Вариант 2
                break;

            case 5://поиск по имени
                femily_tree.searchHuman((ArrayList<Designer_Human>) femily_tree.getTree());


        }
    }
}

