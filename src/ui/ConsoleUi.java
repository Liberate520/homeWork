package ui;

import Presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUi implements View {
    protected Presenter presenter;
    protected Scanner scanner;
    protected Menu menu;
    protected boolean flag;

    public ConsoleUi() {
        scanner = new Scanner(System.in);
        flag = true;
        menu = new Menu(this);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loadTree() throws IOException, ClassNotFoundException {
        presenter.loadTree();
        System.out.println("Загружено дерево из файла. ");
        presenter.printTree();
    }

    @Override
    public void saveTree() throws IOException {
        presenter.saveTree();
        System.out.println("Дерево сохранено в файл. ");
    }

    @Override
    public void printTree() {
        System.out.println("распечатать дерево:");
        presenter.printTree();
    }

    @Override
    public void sortByBirthYear() {
        System.out.println("Сортировка дерева по году рождения:");
        presenter.sortByBirthYear();
    }

    @Override
    public void sortBySecondName() {
        System.out.println("сортировка дерева по фамилиям: ");
        presenter.sortBySecondName();
    }

    @Override
    public void sortBySex() {
        System.out.println("сортировка дерева по полу: ");
        presenter.sortBySex();
    }

    @Override
    public void finish() {
        System.out.println("Работа завершена");
        flag = false;
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        System.out.println("Проект семейное дерево");
        while (flag) {
            printMenu();
            System.out.print("Введите пункт меню:");
            execute();
        }
    }

    public void printMenu() {
        System.out.println(menu.print());
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    private void execute() throws IOException, ClassNotFoundException {
        String inputLine = scanner.nextLine();
        if (checkInput(inputLine)) {
            int choice = Integer.parseInt(inputLine);
            if (checkChoice(choice)) {
                menu.execute(choice);
            }
        }
    }

    private boolean checkInput(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            System.out.println("Неверный ввод команды");
            return false;
        }
    }

    private boolean checkChoice(int choice) {
        if (choice <= menu.size()) {
            return true;
        } else {
            System.out.print("Неверный ввод команды");
            return false;
        }
    }

    public void addHuman() {
        System.out.println("Введите имя:");
        String firstName = scanner.nextLine();
        System.out.println("Введите фамилию:");
        String secondName = scanner.nextLine();
        System.out.println("Введите отчество:");
        String patronymic = scanner.nextLine();
        System.out.println("Введите год рождения в формате 00.00.0000 или 00/00/0000:");
        String birthDay = scanner.nextLine();
        System.out.println("Введите пол варианты (male или female):");
        String sex = scanner.nextLine();
        presenter.addHuman(birthDay, firstName, secondName, patronymic, sex);
    }

}
