package View;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

import Model.*;
import Presenter.*;

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
        hello();
        while (work) {
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("Всего доброго!");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
        presenter.getFamilyInfo();
    }

    public void sortByName() {
        presenter.sortByName();
        presenter.getFamilyInfo();
    }

    public void save() {
        presenter.saveFile();
    }
    public void load() {
        presenter.load();
    }
    public void getFamilyInfo() {
        presenter.getFamilyInfo();
    }

    public void addHuman() {
        System.out.print("Добавить нового человека \nВведите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите пол (Male/Female): ");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.print("Введите дату рождения в формате ГГГГ-ММ-ДД: ");
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());
        LocalDate dateOfDeath = null;
        System.out.print("Введите роль в семье: ");
        String familyStatus = scanner.nextLine();
        //TODO сделать проверку ввода возраста
        System.out.printf("Имя: %s\n", name, "роль в семье: %n\n", familyStatus);
        presenter.addHuman(name, gender, dateOfBirth, dateOfDeath, familyStatus);
    }

    private void hello() {
        System.out.println("Hello World :) !");
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

    private boolean checkTextForInt(String text) {
        if (text.matches("[1-9]")) {
            return true;
        } else {
            inputError();
            return false;
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

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }

}