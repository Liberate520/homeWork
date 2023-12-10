package view;

import model.creatures.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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
        System.out.println("Введите дату рождения в формате год.месяц.день: ");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate date = LocalDate.parse(scanner.nextLine(), dateFormat);
        presenter.addCreature(name, lastName, gend, date);
    }

    public void showTree() {
        System.out.println(presenter.showTree());
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    private void execute() {
        String line = scanner.nextLine();
        int numCommand = Integer.parseInt(line);
        menu.execute(numCommand);
    }
}
