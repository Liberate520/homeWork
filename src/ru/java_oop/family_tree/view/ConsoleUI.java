package ru.java_oop.family_tree.view;

import ru.java_oop.family_tree.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {

    private Presenter presenter;
    private boolean working;
    private MainMenu menu;
    private Scanner scanner;

    public ConsoleUI() {
        this.presenter = new Presenter(this);
        this.working = true;
        this.menu = new MainMenu(this);
        this.scanner = new Scanner(System.in);
    }


    public void endProgram() {
        System.out.println("Exiting program");
        this.working = false;
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (working) {
            System.out.println(menu.formMenu());
            String line = scanner.nextLine();
            try {
                int choice = Integer.parseInt(line);
                if (choice > menu.getSize()) {
                    System.out.println("Incorrect input");
                } else {
                    menu.execute(choice);
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + "Incorrect input");
            }
        }
    }
}
