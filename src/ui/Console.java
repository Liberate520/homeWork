package ui;

import presenter.Presenter;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Console implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private Menu mainMenu;

    public Console() {
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new Menu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (work) {
            presenter.loadFile();
            System.out.println(mainMenu.print());
            int choice = inputNumMenu();
            if (choice == -1){
                System.out.println("Ошибка ввода");
                continue;
            }
            mainMenu.execute(choice);
        }
    }

    private int inputNumMenu() {
        String line = scanner.nextLine();
        if (!checkLine(line)){
            return -1;
        }
        return Integer.parseInt(line);
    }

    private boolean checkLine(String line) {
        if (!line.matches("[0-9]+")){
            return false;
        }
        int choice = Integer.parseInt(line);
        return choice > 0 && choice <= mainMenu.size();
    }

    public void add() {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите пол: ");
        String gender = scanner.nextLine();
//        System.out.println("Введите имя отца: ");
//        String father = scanner.nextLine();
//        System.out.println("Введите имя матери: ");
//        String mother = scanner.nextLine();
        System.out.println("Введите дату рождения в формате 'гггг,мм,дд': ");
        String input = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        presenter.add(name, gender, null, null, birthDate, null);
    }

    public void finish() {
        System.out.println("До свидания!");
        work = false;
    }

    public void getInfo() {
        presenter.getInfo();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void saveFile() {
        presenter.saveFile();
    }

    public void loadFile() {
        presenter.loadFile();
    }
}