package view;

import presenter.Presenter;
import view.check_input_data.CheckInputData;
import view.check_input_data.ICheckInputData;
import view.parse_data.IParseData;
import view.parse_data.ParseData;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String ERROR = "Введено некорректное значение!";
    private static final String PATH = "ft.output";
    private Scanner scanner;
    private Presenter presenter;
    private MainMenu menu;
    private boolean continueWork;
    private ICheckInputData check;
    private IParseData parser;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        menu = new MainMenu(this);
        continueWork = true;
        check = new CheckInputData();
        parser = new ParseData();
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (continueWork) {
            printMenu();
            execute();
        }
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void execute() {
        String line = scanner.nextLine();
        int numCommand = parser.tryParseInt(line);
        if(numCommand != -1) {
            if(check.checkCommand(numCommand, menu)) {
                menu.execute(numCommand);
            }
        }
        else outputError();
    }

    private void outputError() {
        System.out.println(ERROR);
    }

    public void exit() {
        continueWork = false;
    }

    public void addHuman() {
        System.out.println("Введите имя человека:");
        String name = scanner.nextLine();
        LocalDate birthDay = null;
        while (birthDay == null) {
            System.out.println("Укажите дату рождения в формате ДД-ММ-ГГГГ");
            birthDay = parser.tryParseDate(scanner.nextLine());
            if(birthDay == null) {
                printAnswer(ERROR);
            }
        }
        LocalDate deathDay;
        System.out.println("Укажите дату смерти в формате ДД-ММ-ГГГГ (для пропуска нажмите Enter)");
        deathDay = parser.tryParseDate(scanner.nextLine());
        presenter.addHuman(name, birthDay, deathDay);
    }

    public void marry() {
        presenter.outputNumHumanList();
        int firstHuman = -1;
        while (firstHuman == -1) {
            System.out.println("Введите номер первого человека: ");
            firstHuman = parser.tryParseInt(scanner.nextLine());
            if (firstHuman == -1 && correctlyInput(firstHuman)) {
                firstHuman = -1;
                outputError();
            }
        }
        int secondHuman = -1;
        while (secondHuman == -1) {
            System.out.println("Введите номер второго человека: ");
            secondHuman = parser.tryParseInt(scanner.nextLine());
            if (secondHuman == -1 && correctlyInput(secondHuman)) {
                secondHuman = -1;
                outputError();
            }
        }
        presenter.marry(firstHuman, secondHuman);
    }

    public void addChild() {
        presenter.outputNumHumanList();
        int child = -1;
        while (child == -1) {
            System.out.println("Введите номер ребенка: ");
            child = parser.tryParseInt(scanner.nextLine());
            if (child == -1 && correctlyInput(child)) {
                child = -1;
                outputError();
            }
        }
        int parent = -1;
        while (parent == -1) {
            System.out.println("Введите номер родителя: ");
            parent = parser.tryParseInt(scanner.nextLine());
            if (parent == -1 && correctlyInput(parent)) {
                parent = -1;
                outputError();
            }
        }
        presenter.addChild(parent, child);
    }

    public void addParent() {
        presenter.outputNumHumanList();
        int parent = -1;
        while (parent == -1) {
            System.out.println("Введите номер родителя: ");
            parent = parser.tryParseInt(scanner.nextLine());
            if (parent == -1 && correctlyInput(parent)) {
                parent = -1;
                outputError();
            }
        }
        int child = -1;
        while (child == -1) {
            System.out.println("Введите номер ребенка: ");
            child = parser.tryParseInt(scanner.nextLine());
            if (child == -1 && correctlyInput(child)) {
                child = -1;
                outputError();
            }
        }
        presenter.addParent(child, parent);
    }

    public boolean correctlyInput(int numHuman) {
        return numHuman > 1 && numHuman <= presenter.getCountHuman();
    }

    public void outputInfo() {
        presenter.outputInfo();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByBirthDay() {
        presenter.sortByBirthDay();
    }

    public void save() {
        presenter.save(PATH);
        System.out.println("Успешно сохранено!");
    }

    public void load() {
        presenter.load(PATH);
        System.out.println("Успешно загружено!");
    }
}
