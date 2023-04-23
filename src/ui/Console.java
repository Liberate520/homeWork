package ui;

import presenter.Presenter;

import java.util.*;

public class Console implements View {
    private Presenter presenter;
    private Scanner scanner;
    private Menu menu;
    private boolean temp;

    public Console() {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        temp = true;
    }

    public void showPerson() {
        presenter.humanList();
    }

    public void addPerson() {
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Введите пол человека: male(м)/female(ж)");
        String gender = scanner.nextLine();
        System.out.println("Введите дату рождения человека в формате 'год-месяц-день'");
        String birthDate = scanner.nextLine();
        System.out.println("Введите дату смерти человека в формате 'год-месяц-день'");
        String deathDate = scanner.nextLine();
        System.out.println("Введите имя отца человека");
        String father = scanner.nextLine();
        System.out.println("Введите имя матери человека");
        String mother = scanner.nextLine();
        presenter.addHuman(name, gender, birthDate, deathDate, father, mother);
    }

    public void searchPerson() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        presenter.findHuman(name);
    }

    public void sortName() {
        presenter.sortByName();
    }

    public void sortBirthdate() {
        presenter.sortByBirthDate();
    }

    public void exit() {
        temp = false;
    }

    @Override
    public void run() {
        while (temp) {
            menu = new Menu(this);
            while (temp) {
                System.out.println(menu.print());
                System.out.print("Выберите пункт Меню -> ");
                String command = scanner.nextLine();
                if (check(command)) {
                    menu.execute(Integer.parseInt(command));
                } else {
                    System.out.println("Введите число!");
                }
            }
        }
    }

    private boolean check(String check) {
        return check.matches("[0-9]+") && Integer.parseInt(check) <= menu.getSize() && Integer.parseInt(check) > 0;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
