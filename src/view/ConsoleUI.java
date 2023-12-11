package view;

import model.creatures.Gender;
import presenter.Presenter;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    public void setWork(boolean work) {
        this.work = work;
    }

    @Override
    public void start() {
        System.out.println("Здравствуйте!");
        while (work) {
            printMenu();
            execute();
        }
    }

    //TODO: Обработать возможные ошибки ввода
    public void addCreature() {
        Gender gend = Gender.Male;
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию: ");
        String lastName = scanner.nextLine();
        System.out.println("Выберите пол: 1. Мужской, 2. Женский");
        Integer gender = Integer.parseInt(scanner.nextLine());
        if (gender == 2) {
            gend = Gender.Female;
        }
        System.out.println("Введите дату рождения в формате год-месяц-день: (1990-09-10):");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = null;
        try {
            date = LocalDate.parse(scanner.nextLine(), dateFormat);
        } catch (DateTimeParseException e) {
            System.out.println(e);
        }
        if (presenter.addCreature(name, lastName, gend, date)) {
            System.out.println("Человек успешно добавлен!");
        } else {
            System.out.println("Не удалось создать такого человека");
        }
    }

    public void showTree() {
        System.out.println(presenter.showTree());
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void execute() {
        String line = scanner.nextLine();
        int numCommand = 0;
        try {
            numCommand = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        try {
            menu.execute(numCommand);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

    }

    public void showNotInTree() {
        System.out.println(presenter.showNotInTree());
    }

    //TODO: Обработать ошибки ввода
    public void setChild() {
        System.out.println("Введите ID родителя:");
        Integer parentID = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите ID ребенка:");
        Integer childID = Integer.parseInt(scanner.nextLine());
        if (presenter.setChild(parentID, childID)) {
            System.out.println("Ребенок успешно задан");
        } else {
            System.out.println("Не удалось задать ребенка");
        }
    }

    public void showAll() {
        System.out.println(presenter.showAll());
    }

    public void ShowAllInfo() {
        System.out.println("Введите ID человека");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println(presenter.showAllInfo(id));
    }
}
