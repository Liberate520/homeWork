package ru.gb.family_tree.family_tree.view;

import ru.gb.family_tree.family_tree.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    @Override
    public void start() {
        System.out.println("Программа Семейное Древо");

    }

    @Override
    public void exit() {

    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
