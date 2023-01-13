package Homework_4;

import java.util.ArrayList;
import java.util.Scanner;

public class CommunicationWithUsers {
    //
    Scanner iScanner = new Scanner(System.in);

    Designer_Human designer_human = new Designer_Human();//Экземпляр класса
    Femily_Tree femily_tree = new Femily_Tree();//Экземпляр класса
    Service service = new Service(femily_tree);

    /**
     * Вызов класса общения с пользователем.
     */
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
                2.Добавить пользователя с Id
                3.Добавить детей
                4.Добавить родителей
                5.Показать все древо
                6.Поиск по имени
                7.Сортировка
                """);
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
                String choiceNameId = iScanner.nextLine();
                String choiceGenderId = iScanner.nextLine();
                int choiceDateId = iScanner.nextInt();
                femily_tree.addingPeopleWithAnId(choiceNameId,choiceGenderId,choiceDateId);
                break;

            case 3:
                System.out.println("К кому будем добавлять детей ?");
                femily_tree.printDrevo(femily_tree.getTree());
                designer_human.addChildren();


            case 4:
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

            case 5:
                System.out.println("Показать все древо");
                femily_tree.ShowALL(femily_tree.getTree()); //Вариант 1
                femily_tree.printTheTreeForEach(); //Вариант 2
                break;


            case 6:
                System.out.println("Введите имя");
                String choiceNameCase5 = iScanner.nextLine();
                femily_tree.showName(choiceNameCase5);
                break;
            case 7:
                sortingTheSheet();
                break;


        }
    }

    /**
     * меню сортировки
     */
    public void sortingTheSheet(){
        System.out.println("""
              Выберите варианты сортировки
              1.По имени
              2.По дате рождения
              """);
        int choiceSort =iScanner.nextInt();
        switch (choiceSort){
            case 1:
                service.sortByName();
                service.sortLamdaByName();//сортировка с лямда выражением
                service.sortByStreamByName();
                break;
            case 2:
                service.sortByDateOfBirth();
                service.sortByStreamByDate();
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
                2.Добавить пользователя с Id
                3.Добавить детей
                4.Добавить родителей
                5.Показать все древо
                6.Поиск по имени
                7.Сортировка
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
                femily_tree.printTheTreeForEach(); //Вариант 3
                break;

            case 5://поиск по имени
                femily_tree.searchHuman((ArrayList<Designer_Human>) femily_tree.getTree());

            case 6:
            case 7:
                sortingTheSheet();
                break;

        }
    }
}

