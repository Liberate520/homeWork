package ru.gb.family_tree.ui;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
    }

    @Override
    public void start() {
        while (work){
            hello();
            choice(scanner.nextLine());
        }
    }

    private void hello () {
        System.out.println("Добро пожаловать! Что Вы хотите сделать?");
        System.out.println("1 - просмотреть все генеалогическое древо");
        System.out.println("2 - добавить человека");
        System.out.println("3 - просмотреть информацию по ID");
        System.out.println("4 - сортировка списка по ID");
        System.out.println("5 - сортировка списка по фамилии");
        System.out.println("6 - выход");
    }

    private void choice (String value) {
        if (checkInt(value)) {
            int choice = Integer.parseInt(value);
            switch (choice) {
                case 1:
                    viewAll();
                    break;

                case 2:
                    addNewHuman();
                    break;

                case 3:
                    infoById();
                    break;

                case 4:
                    sortId();
                    break;

                case 5:
                    sortLastname();
                    break;

                case 6:
                    finish();
                    break;

                default:
                    System.out.println("Неверное значение.");
                    break;
            }
        }
    }

    private void finish() {
        System.out.println("Работа приложения завершена.");
        work = false;
    }

    private void viewAll() {
        presenter.allTree();
    }

    private void addNewHuman() {
        System.out.println("Введите фамилию: ");
        String lastname = scanner.nextLine();
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите пол (Male, Female): ");
        Gender gender = Gender.valueOf(scanner.nextLine());
        presenter.addBody(lastname, name, gender);
    }

    private void infoById() {
        System.out.println("Введите ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        presenter.getBodyInfoById(id);
    }

    private void sortId() {
        presenter.sortById();
    }

    private void sortLastname() {
        presenter.sortByLastname();
    }
    private String scan() {
        System.out.println("Введите значение");
        return scanner.nextLine();
    }

    private boolean checkInt (String text) {
        try {
            if (Integer.parseInt(text) > 0 && Integer.parseInt(text) < 7) {
                return true;
            }
        }
            catch (NumberFormatException e){
                System.out.println("Вы ввели неверное значение!");
        }
        return false;
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
