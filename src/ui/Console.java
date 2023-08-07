package ui;

import presenter.Presenter;

import java.util.Scanner;

public class Console implements ConsoleUI {
    private final Scanner scanner;
    private final Presenter presenter;

    public Console() {
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter();
    }

    @Override
    public void start() {
        start:
        {
            System.out.println("Старт программы");
            while (true) {
                printMenu();
                switch (scan()) {
                    case MenuPoint.ADD_PERSON -> System.out.println(ParserPerson.addPerson(scanner, presenter));
                    case MenuPoint.PRINT -> System.out.println(presenter.getTreeInfo());
                    case MenuPoint.SAVE -> presenter.saveTree(".\\src\\familyTree\\savedFiles\\TreeOfHumans");
                    case MenuPoint.LOAD -> presenter.loadTree(".\\src\\familyTree\\savedFiles\\TreeOfHumans");
                    case MenuPoint.SORT_BY_GENDER -> presenter.sortGender();
                    case MenuPoint.SORT_BY_AGE -> presenter.sortAge();
                    case MenuPoint.SORT_BY_NAME -> presenter.sortName();
                    case MenuPoint.ADD_CHILDREN -> {
                        System.out.println("Выберите родителя для ребенка(id)");
                        int idParent;
                        idParent = Integer.parseInt(scan());
                        System.out.println("Выберите ребенка(id)");
                        int idChild;
                        idChild = Integer.parseInt(scan());
                        presenter.addParent(idChild, idParent);
                    }
                    case MenuPoint.EXIT -> {
                        break start;
                    }
                }
            }
        }
    }

    @Override
    public void printMenu() {
        System.out.printf("%-40s %s \n", "Для выхода из программы нажмите: ", MenuPoint.EXIT);
        System.out.printf("Выберите пункт меню: \n");
        System.out.printf("%-40s %s \n", "Для добавления человека нажмите: ", MenuPoint.ADD_PERSON);
        System.out.printf("%-40s %s \n", "Для печати нажмите: ", MenuPoint.PRINT);
        System.out.printf("%-40s %s \n", "Для сохранения программы нажмите: ", MenuPoint.SAVE);
        System.out.printf("%-40s %s \n", "Для загрузки программы нажмите: ", MenuPoint.LOAD);
        System.out.printf("%-40s %s \n", "Для сортировки по полу нажмите: ", MenuPoint.SORT_BY_GENDER);
        System.out.printf("%-40s %s \n", "Для сортировки по возрасту нажмите: ", MenuPoint.SORT_BY_AGE);
        System.out.printf("%-40s %s \n", "Для сортировки по имени нажмите: ", MenuPoint.SORT_BY_NAME);
        System.out.printf("%-40s %s \n","Для добавления ребенка нажмите: ",MenuPoint.ADD_CHILDREN);
    }

    private String scan() {
        return scanner.nextLine();
    }

    }
