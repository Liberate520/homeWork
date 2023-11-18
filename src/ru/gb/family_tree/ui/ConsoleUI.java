package ru.gb.family_tree.ui;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.presenter.Presenter;
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
        if (checkMenu(value)) {
            int num = Integer.parseInt(value);
            menu.execute(num);
        }
    }

    public void finish() {
        System.out.println("Работа приложения завершена.");
        scanner.close();
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
        Gender gender = checkGender();
        presenter.addBody(lastname, name, gender);
    }

    private Gender checkGender() {
        String answer = null;
        boolean i = true;
        while (i) {
            answer = scanner.nextLine();
            if (answer.equals("Male") || answer.equals("Female")) {
                i = false;
            }
            else System.out.println("Неверное значение! Попробуйте еще раз.");
        }
        return Gender.valueOf(answer);
    }

    public void addBirthdate() {
        System.out.println("Введите Id");
        int id = checkId();
        System.out.println("Введите год рождения");
        int year = checkInt();
        System.out.println("Введите месяц рождения");
        int month = checkInt();
        System.out.println("Введите день рождения");
        int day = checkInt();
        presenter.setBirthday(id, year, month, day);
    }

    private int checkInt() {
        int value = 0;
        boolean i = true;
        while (i) {
            String text = scanner.nextLine();
            if (text.matches("[0-9]+")){
                value = Integer.parseInt(text);
                i = false;
            } else {
                System.out.println("Неверное значение! Введите целое число.");
            }
        }
        return value;
    }

    private int checkId() {
        boolean i = true;
        int id = 0;
        while (i) {
            id = checkInt();
            if (presenter.checkId(id)) {
                i = false;
                return id;
            }
            else System.out.println("Введите другое значение.");
        }
        return id;
    }

    public void addDeathdate() {
        System.out.println("Введите Id");
        int id = checkId();
        System.out.println("Введите год смерти");
        int year = checkInt();
        System.out.println("Введите месяц смерти");
        int month = checkInt();
        System.out.println("Введите день смерти");
        int day = checkInt();
        presenter.setDeathdate(id, year, month, day);
    }

    public void infoById() {
        System.out.println("Введите ID: ");
        int id = checkId();
        presenter.getBodyInfoById(id);
    }

    public void addSpouse() {
        System.out.println("Введите ID одного из супругов: ");
        int one = checkId();
        System.out.println("Введите ID второго супруга: ");
        int two = checkId();
        if (one == two) {
            System.out.println("Id одинаковы. Данные не добавлены.");
        }
        else {
            presenter.addSpouse(one, two);
        }
    }

    public void addChild() {
        System.out.println("Введите ID родителя: ");
        int parentId = checkId();
        System.out.println("Введите ID ребенка: ");
        int childId = checkId();
        if (parentId == childId) {
            System.out.println("Id одинаковы. Данные не добавлены.");
        }
        else {
            presenter.addChild(parentId, childId);
        }
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

    private boolean checkMenu (String text) {
        try {
            if (Integer.parseInt(text) > 0 && Integer.parseInt(text) <= menu.getSize()) {
                return true;
            }
        }
            catch (NumberFormatException e){
                System.out.println(e.getMessage());
        }
        System.out.println("Вы ввели неверное значение!");
        return false;
    }

    public void save() {
        presenter.save();
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

}
