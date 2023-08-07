package view;

import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String ERROR = "Введено некорректное значение!";
    private static final String PATH = "ft.output";
    private Scanner scanner;
    private Presenter presenter;
    private MainMenu menu;
    private boolean continueWork;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        menu = new MainMenu(this);
        continueWork = true;
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
        if(checkInput(line)) {
            int numCommand = Integer.parseInt(line);
            if(checkCommand(numCommand)) {
                menu.execute(numCommand);
            }
        }
        else outputError();
    }

    private boolean checkInput(String text) {
        try {
            Integer.parseInt(text);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    private boolean checkCommand(int numCommand) {
        if(numCommand > 0 && numCommand <= menu.getSize()) {
            return true;
        }
        else {
            outputError();
            return false;
        }
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
            birthDay = inputDate(scanner.nextLine());
            if(birthDay == null) {
                printAnswer(ERROR);
            }
        }
        LocalDate deathDay;
        System.out.println("Укажите дату смерти в формате ДД-ММ-ГГГГ (для пропуска нажмите Enter)");
        deathDay = inputDate(scanner.nextLine());
        presenter.addHuman(name, birthDay, deathDay);
    }

    private LocalDate inputDate(String text) {
        String[] date = text.split("-");
        try {
            int day = Integer.parseInt(date[0]);
            int mouth = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            return LocalDate.of(year, mouth, day);
        }
        catch (Exception e) {
            return null;
        }
    }

    private int parseInt(String text) {
        try {
            return Integer.parseInt(text);
        }
        catch (Exception e) {
            return -1;
        }
    }
    public void marry() {
        presenter.outputNumHumanList();
        int firstHuman = -1;
        while (firstHuman == -1) {
            System.out.println("Введите номер первого человека: ");
            firstHuman = parseInt(scanner.nextLine());
            if (firstHuman == -1 && correctlyInput(firstHuman)) {
                firstHuman = -1;
                outputError();
            }
        }
        int secondHuman = -1;
        while (secondHuman == -1) {
            System.out.println("Введите номер второго человека: ");
            secondHuman = parseInt(scanner.nextLine());
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
            child = parseInt(scanner.nextLine());
            if (child == -1 && correctlyInput(child)) {
                child = -1;
                outputError();
            }
        }
        int parent = -1;
        while (parent == -1) {
            System.out.println("Введите номер родителя: ");
            parent = parseInt(scanner.nextLine());
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
            parent = parseInt(scanner.nextLine());
            if (parent == -1 && correctlyInput(parent)) {
                parent = -1;
                outputError();
            }
        }
        int child = -1;
        while (child == -1) {
            System.out.println("Введите номер ребенка: ");
            child = parseInt(scanner.nextLine());
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
