package view;

import java.time.LocalDate;
import java.util.Scanner;

import model.FamilyModel.*;
import model.HumanModel.*;
import model.service.*;
import presenter.Presenter;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);

    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        init();
        while (work) {
            printMenu();
            execute();
        }

    }

    private void init() {
        System.out.println("Загрузить из файла? Y/N");
        if (scanner.nextLine().equals("Y")) {
            System.out.println("Введите имя файла: ");
            presenter = new Presenter(this, scanner.nextLine());
        } else {
            presenter = new Presenter(this);
        }

    }

    public void finish() {
        System.out.println("До свидания");
        work = false;
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)) {
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand < menu.getSize() + 1) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    public void saveInFile() {
        System.out.println("Введите имя файла для сохранения:");
        presenter.SaveInFile(scanner.nextLine());
    }

    public void loadFile() {
        System.out.println("Введите имя файла для загрузки:");
        presenter.LoadFile(scanner.nextLine());
    }

    public void addHuman() {
        System.out.println("Введите Имя:");
        String firstName = scanner.nextLine();
        System.out.println("Введите Фамилию:");
        String lastName = scanner.nextLine();
        System.out.println("Введите пол: M or F");
        Gender gender = setGender(scanner.nextLine());

        System.out.println("Введите год рождения:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите месяц рождения:");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите день рождения:");
        int day = Integer.parseInt(scanner.nextLine());
        LocalDate start = LocalDate.of(year, month, day);
        System.out.println("Человек еще жив?:Y/N");

        String q = scanner.nextLine();

        if (q.equals("N")) {
            System.out.println("Введите год смерти:");
            int yeard = Integer.parseInt(scanner.nextLine());
            System.out.println("Введите месяц смерти:");
            int monthd = Integer.parseInt(scanner.nextLine());
            System.out.println("Введите день смерти:");
            int dayd = Integer.parseInt(scanner.nextLine());
            LocalDate stop = LocalDate.of(yeard, monthd, dayd);
            Human human = new Human(firstName, lastName,
                    null, null, null,
                    gender, start, stop);
            presenter.addEntity(human);
        } else {
            Human human = new Human(firstName, lastName,
                    null, null, null,
                    gender, start, null);
            presenter.addEntity(human);
        }

    }

    private Gender setGender(String value) {
        if (value.equals("M"))
            return Gender.Male;
        else
            return Gender.Female;
    }

    public void PrintAll() {
        presenter.PrintAll();
    }

}
