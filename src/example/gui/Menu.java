package org.example.gui;

import org.example.presenter.Presenter;

import java.util.ArrayList;
import java.util.Map;

public class Menu {
    private Integer indexEditingOne = -1;
    private ArrayList <Map<String, String>> listPrintHuman;
    private final Presenter presenter;
    private ConsoleUi consoleUi;


    public Menu(Presenter presenter) {
        this.presenter = presenter;
        this.listPrintHuman = presenter.setCommandFromView("1", "", indexEditingOne);

    }

    public void setConsoleUi(ConsoleUi consoleUi) {
        this.consoleUi = consoleUi;
    }

    public void mainMenu(String input, String navigationMenu){
        if (input.equals("1") && navigationMenu.equals("0")){
                printListHuman(listPrintHuman);
                consoleUi.setNavigationMenu("1-list");
                System.out.println("back - Выход в предыдущее меню");
        } else if (navigationMenu.equals("1-list")){
            if (input.equals("back")){
                consoleUi.setNavigationMenu("0");
            } else {
                printHuman(listPrintHuman, input);
                printListHuman(listPrintHuman);
            }
            System.out.println("back - Выход в предыдущее меню");
        } else if (input.equals("2") && navigationMenu.equals("0")){
            System.out.println("***Введите Ф.И.О***");
            consoleUi.setNavigationMenu("2-addHuman");
        } else if (input.length() > 0 && navigationMenu.equals("2-addHuman")){
            presenter.setCommandFromView("addH", input, indexEditingOne);
            this.listPrintHuman = presenter.setCommandFromView("1", "", indexEditingOne);
            consoleUi.setNavigationMenu("0");
        } else if (input.equals("3") && navigationMenu.equals("0")) {
            printListHuman(listPrintHuman);
            consoleUi.setNavigationMenu("3-list");
            System.out.println("back - Выход в предыдущее меню");
        } else if (navigationMenu.equals("3-list")) {
            if (input.equals("back")) {
                consoleUi.setNavigationMenu("0");
            } else {
                this.indexEditingOne = Integer.parseInt(input) - 1;  // индекс выбраного Human для редактирования
                System.out.println(getMenuEditing());
                consoleUi.setNavigationMenu("3->-list");
            }
        }else if (navigationMenu.equals("3->-list")){
            if (input.equals("1")){
                System.out.println("***Введите Ф.И.О***");
                consoleUi.setNavigationMenu("3->->-list");
            } else if (input.equals("back")){
                consoleUi.setNavigationMenu("0");
            } else if (input.equals("2")){
                consoleUi.setNavigationMenu("3->->>-list");
                System.out.println("1 - Мужчина\n2 - Женщина");
            } else if(input.equals("3")){
                consoleUi.setNavigationMenu("3->->>>-list");
                System.out.println("Ведите дату формате -день%месяц%год-");
            } else if(input.equals("4")){
                consoleUi.setNavigationMenu("3->->>>>-list");
                System.out.println("Ведите дату формате -день%месяц%год-");
            } else if(input.equals("5")){
                consoleUi.setNavigationMenu("3->->>>>>-list");
                printListHuman(listPrintHuman);
            } else if(input.equals("6")){
                consoleUi.setNavigationMenu("3->->>>>>>-list");
                printListHuman(listPrintHuman);
            } else if(input.equals("7")){
                consoleUi.setNavigationMenu("3->->>>>>>>-list");
                printListHuman(listPrintHuman);
            } else if(input.equals("8")){
                consoleUi.setNavigationMenu("3->->>>>>>>>-list");
                printListHuman(listPrintHuman);
            }

        } else if (navigationMenu.equals("3->->-list")){
            presenter.setCommandFromView("EditingName", input, indexEditingOne);
            this.listPrintHuman = presenter.setCommandFromView("1", "", indexEditingOne);
            consoleUi.setNavigationMenu("3->-list");
            System.out.println(getMenuEditing());
        } else if (navigationMenu.equals("3->->>-list")){
            presenter.setCommandFromView("gender", input, indexEditingOne);
            this.listPrintHuman = presenter.setCommandFromView("1", "", indexEditingOne);
            consoleUi.setNavigationMenu("3->-list");
            System.out.println(getMenuEditing());
        } else if (navigationMenu.equals("3->->>>-list")){
            presenter.setCommandFromView("dateB", input, indexEditingOne);
            this.listPrintHuman = presenter.setCommandFromView("1", "", indexEditingOne);
            consoleUi.setNavigationMenu("3->-list");
            System.out.println(getMenuEditing());
        } else if (navigationMenu.equals("3->->>>>-list")){
            presenter.setCommandFromView("dateD", input, indexEditingOne);
            this.listPrintHuman = presenter.setCommandFromView("1", "", indexEditingOne);
            consoleUi.setNavigationMenu("3->-list");
            System.out.println(getMenuEditing());
        } else if (navigationMenu.equals("3->->>>>>-list")){
            presenter.setCommandFromView("mother", input, indexEditingOne);
            this.listPrintHuman = presenter.setCommandFromView("1", "", indexEditingOne);
            consoleUi.setNavigationMenu("3->-list");
            System.out.println(getMenuEditing());
        } else if (navigationMenu.equals("3->->>>>>>-list")) {
            presenter.setCommandFromView("father", input, indexEditingOne);
            this.listPrintHuman = presenter.setCommandFromView("1", "", indexEditingOne);
            consoleUi.setNavigationMenu("3->-list");
            System.out.println(getMenuEditing());
        } else if (navigationMenu.equals("3->->>>>>>>-list")) {
            presenter.setCommandFromView("children", input, indexEditingOne);
            this.listPrintHuman = presenter.setCommandFromView("1", "", indexEditingOne);
            consoleUi.setNavigationMenu("3->-list");
            System.out.println(getMenuEditing());
        } else if (navigationMenu.equals("3->->>>>>>>>-list")) {
            presenter.setCommandFromView("brothersAndSisters", input, indexEditingOne);
            this.listPrintHuman = presenter.setCommandFromView("1", "", indexEditingOne);
            consoleUi.setNavigationMenu("3->-list");
            System.out.println(getMenuEditing());
        } else if (input.equals("4") && navigationMenu.equals("0")) {
            printListHuman(listPrintHuman);
            consoleUi.setNavigationMenu("4-list");
            System.out.println("back - Выход в предыдущее меню");
        } else if (navigationMenu.equals("4-list")){
            this.indexEditingOne = Integer.parseInt(input) - 1;
            presenter.setCommandFromView("remove", "", indexEditingOne);
            this.listPrintHuman = presenter.setCommandFromView("1", "", indexEditingOne);
            consoleUi.setNavigationMenu("0");
        }
    }


    public void printListHuman(ArrayList <Map<String, String>> listPrintHuman){
        for (int i = 0; i < listPrintHuman.size(); i++) {
            System.out.print((i + 1) + " - ");
            System.out.println(String.format("%s",listPrintHuman.get(i).keySet()));
        }
    }

    public void printHuman(ArrayList <Map<String, String>> listPrintHuman, String index){
        System.out.println(listPrintHuman.get(Integer.parseInt(index) - 1).values());
    }





    public String getMainMenu(){
        return "1 - Вывод на экран\n2 - Добавить человека\n3 - Добавить/изменить данные\n" +
                "4 - Удалить человека из списка\n5 - Выход\n";
    }

    public String getMenuEditing(){
        return "*******ЧТО ВЫ ХОТИТЕ ДОБАВИТЬ/ИЗМЕНИТЬ ?*******\n\n1 - Ф.И.О.\n2 - ПОЛ\n3 - ДАТУ РОЖДЕНИЯ\n" +
                "4 - ДОБАВИТЬ/РЕДАКТИРОВАТЬ ДАТУ СМЕРТИ\n" +
                "5 - mother\n6 - father\n7 - children\n" +
                "8 - brothersAndSisters\nback - Вернуться в предыдущее меню\n";
    }


}
