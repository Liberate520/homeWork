package ru.gb.family_tree.view;

import ru.gb.family_tree.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    boolean work;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
    }

    @Override
    public void start() {
        System.out.println("Приветствие");
        while (work) {
            printMenu();
            choice();
        }
    }

    private void choice() {
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                addHuman();
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                finish();
                break;
            default:
                error();
        }
    }

    private void error() {
        System.out.println("Введено некорректное значение");
    }

    private void addHuman() {
        System.out.println("Укажите имя");
        String name = scanner.nextLine();
        System.out.println("Укажите пол");
        String gender = scanner.nextLine();
        System.out.println("Укажите дату рождения");
        int age = Integer.parseInt(scanner.nextLine());
    }

    private static void printMenu() {
        System.out.println("1. Добавить человека в древо");
        System.out.println("2. Получить древо");
        System.out.println("3. Отсортировать по имени");
        System.out.println("4. Отсортировать по дате рождения");
        System.out.println("5. Закончить работу");
    }

    private void finish() {
        System.out.println("До новых встреч");
        work = false;
    }

    @Override
    public void printAnswer(String answer) {

    }
}
