package ru.gb.family_tree.ui;

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
        System.out.println("6 - детальная информация о человеке по ID");
        System.out.println("7 - выход");
        return scanner.nextLine();
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
