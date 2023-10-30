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
        }
    }

    private String hello () {
        System.out.println("Добро пожаловать! Что Вы хотите сделать?");
        System.out.println("1 - просмотреть все генеалогическое древо");
        System.out.println("2 - добавить человека");
        System.out.println("3 - просмотреть информацию по ID");
        System.out.println("4 - сортировка списка по ID");
        System.out.println("5 - сортировка списка по фамилии");
        System.out.println("6 - выход");
        return scanner.nextLine();
    }

    public void finish() {
        System.out.println("Работа приложения завершена.");
        work = false;
    }

    public void viewAll() {
        presenter.allTree();
    }

    public void addNewHuman() {
        System.out.println("Введите фамилию: ");
        String lastname = scanner.nextLine();
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите пол (Male, Female): ");
        Gender gender = Gender.valueOf(scanner.nextLine());
        presenter.addBody(lastname, name, gender);
    }

    public void infoById() {
        System.out.println("Введите ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        presenter.getBodyInfoById(id);
    }

    public void sortId() {
        presenter.sortById();
    }

    public void sortLastname() {
        presenter.sortByLastname();
    }
    private String scan() {
        System.out.println("Введите значение");
        return scanner.nextLine();
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
