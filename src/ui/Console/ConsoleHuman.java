package ui.Console;

import presenter.PresenterHuman;
import ui.Menu.MenuHuman;
import ui.View.ViewHuman;

import java.util.Scanner;

public class ConsoleHuman implements ViewHuman {
    private PresenterHuman presenterHuman;
    private Scanner scanner;
    private boolean work;
    private MenuHuman menuHuman;

    public ConsoleHuman() {
        scanner = new Scanner(System.in);
        menuHuman = new MenuHuman(this);
        work = true;
    }

    private void hello(){
        System.out.println("Доброго времени суток!");
    }

    @Override
    public void start() {
        hello();
        while (work) {
            showMenu();
            execute();
        }
    }

    private void showMenu(){
        menuHuman.showMenu();
    }

    private void execute(){
        System.out.print("Введите номер команды: ");
        int commandNumber = setNumber();
        menuHuman.execute(commandNumber);
    }

    private int setNumber() {
        boolean string = true;
        int number = 0;
        while (string) {
            try {
                number = Integer.parseInt(scanner.nextLine());
                string = false;
            } catch (NumberFormatException e) {
                System.out.print("Вы ввели не число. Повторите попытку ввода: ");
            }
        }
        return number;
    }


    @Override
    public void finishWork() {
        System.out.println("Спасибо за работу! Досвидания.");
        work = false;
    }

    @Override
    public void getInfo() {
        System.out.println(presenterHuman.getInfo());
    }

    @Override
    public void save() {
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();
        presenterHuman.save(fileName + ".txt");
    }

    @Override
    public void upload() {
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();
        presenterHuman.upload(fileName);
    }

    @Override
    public void addChild() {
        System.out.print("Введите имя родителя ребенка: ");
        String parentName = scanner.nextLine();
        System.out.print("Введите пол ребенка: ");
        String gender = scanner.nextLine();
        System.out.print("Введите имя ребенка: ");
        String childName = scanner.nextLine();
        presenterHuman.addChild(parentName, gender, childName);
    }

    @Override
    public void addMember() {
        System.out.print("Введите пол: ");
        String gender = scanner.nextLine();
        System.out.print("Введите имя: ");
        String firstName = scanner.nextLine();
        System.out.print("Введите фамилию: ");
        String lastName = scanner.nextLine();
        presenterHuman.addMember(gender, firstName, lastName);
    }

    @Override
    public void getMarried() {
        System.out.print("Введите имя первого партнера: ");
        String name1 = scanner.nextLine();
        System.out.print("Введите имя второго партнера: ");
        String name2 = scanner.nextLine();
        presenterHuman.getMarried(name1, name2);

    }

    @Override
    public void setPresenter(PresenterHuman presenterHuman) {
        this.presenterHuman = presenterHuman;
    }
}
