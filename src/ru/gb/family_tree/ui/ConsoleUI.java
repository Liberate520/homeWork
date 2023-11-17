package ru.gb.family_tree.ui;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        hello();
        while(work) {
            printMenu();
            choice();
        }
    }

    private void hello () {
        System.out.println("Добро пожаловать!");
    }

    private void choice () {
        String value = scanner.nextLine();
        if (checkInt(value)) {
            int num = Integer.parseInt(value);
            menu.execute(num);
        }
    }

    public void finish() {
        System.out.println("Работа приложения завершена.");
        work = false;
    }

    private void printMenu() {
        System.out.println("Выберите пункт меню.");
        System.out.println(menu.menu());
    }

    public void load() {
        presenter.load();
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

    public void addBirthdate() {
        System.out.println("Введите Id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите год рождения");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите месяц рождения");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите день рождения");
        int day = Integer.parseInt(scanner.nextLine());
        presenter.setBirthday(id, year, month, day);
    }

    public void addDeathdate() {
        System.out.println("Введите Id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите год смерти");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите месяц смерти");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите день смерти");
        int day = Integer.parseInt(scanner.nextLine());
        presenter.setDeathdate(id, year, month, day);
    }

    public void infoById() {
        System.out.println("Введите ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        presenter.getBodyInfoById(id);
    }

    public void addSpouse() {
        System.out.println("Введите ID одного из супругов: ");
        int one = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите ID второго супруга: ");
        int two = Integer.parseInt(scanner.nextLine());
        presenter.addSpouse(one, two);
    }

    public void addChild() {
        System.out.println("Введите ID родителя: ");
        int parentId = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите ID ребенка: ");
        int childId = Integer.parseInt(scanner.nextLine());
        presenter.addChild(parentId, childId);
    }
    public void sortId() {
        presenter.sortById();
    }

    public void sortLastname() {
        presenter.sortByLastname();
    }

    public void sortAge() {
        presenter.sortByAge();
    }
    public String scan() {
        System.out.println("Введите значение");
        return scanner.nextLine();
    }

    public boolean checkInt (String text) {
        try {
            if (Integer.parseInt(text) > 0 && Integer.parseInt(text) <= menu.getSize()) {
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


    public void save() {
        presenter.save();
    }
}
