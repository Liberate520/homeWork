package org.genealogy.view;

import org.genealogy.presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private static Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("Выход");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }

    public void addHuman() throws IOException {
        System.out.println("Введите имя человека:");
        String firstName = scanner.nextLine();
        System.out.println("Введите фамилию человека:");
        String lastName = scanner.nextLine();
        presenter.addHuman(firstName, lastName);
    }

    public void addDateOfBirth() {
        System.out.println("Введите ID:");
        int id = scanner.nextInt();
        System.out.println("Введите дату рождения:");
        System.out.println("Введите день:");
        int day = scanner.nextInt();
        System.out.println("Введите месяц:");
        int month = scanner.nextInt();
        System.out.println("Введите год:");
        int year = scanner.nextInt();
        presenter.addDateOfBirth(id, day, month, year);
    }

    public void addChild() {
        System.out.println("Введите ID родителя:");
        int parentId = scanner.nextInt();
        System.out.println("Введите ID ребенка:");
        int childId = scanner.nextInt();
        presenter.addChild(parentId, childId);
    }

    public static void saveTreeToFile() throws IOException {
        presenter.saveTreeToFile();
        System.out.println("Дерево сохранено");
    }

    public static void loadTreeFromFile() throws IOException, ClassNotFoundException {
        presenter.loadTreeFromFile();
        System.out.println("Дерево загружено");
    }

    private void hello(){
        System.out.println("Генеалогическое дерево");
    }

    private void execute() throws IOException, ClassNotFoundException {
        System.out.println("Введите номер команды:");
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand < menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }
}