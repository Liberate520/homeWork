package ru.medved_sa.tree_family.view;

import ru.medved_sa.tree_family.presenter.Presenter;

import java.util.Scanner;

public class Console implements View {

    private Presenter presenter;
    private Scanner scanner;
    private Menu menu;
    private boolean work;

    @Override
    public void start() {
        while (work) {
            System.out.println(menu.print());
            String choice = scanner.nextLine();
            menu.execute(choice);
        }
    }

    @Override
    public void print(String answer) {
        System.out.println(answer);
    }

    public Console() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
    }

    public void getHumanList() {
        presenter.getHumanList();
    }

    public void addHuman() {
        System.out.println("Укажите имя человека: ");
        String newName = scanner.nextLine();
        System.out.println("Введите дату рождения человека (год месяц день) ");
        String newStrAge = scanner.nextLine();
        System.out.println("Введите пол человека (Male или Female) ");
        String gender = scanner.nextLine();
        presenter.addHuman(newName, gender, newStrAge);

    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void finish() {
        System.out.println("До новых встреч...");
        presenter.saveFile();
        work = false;
    }

}
