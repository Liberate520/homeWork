package ui.Console;

import presenter.PresenterDog;
import ui.Menu.MenuDog;
import ui.View.ViewDog;

import java.util.Scanner;

public class ConsoleDog implements ViewDog {
    private PresenterDog presenterDog;
    private Scanner scanner;
    private boolean work;
    private MenuDog menu;

    public ConsoleDog() {
        scanner = new Scanner(System.in);
        menu = new MenuDog(this);
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
        menu.showMenu();
    }

    private void execute(){
        System.out.print("Введите номер команды: ");
        int commandNumber = setNumber();
        menu.execute(commandNumber);
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
        System.out.println(presenterDog.getInfo());
    }

    @Override
    public void save() {
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();
        presenterDog.save(fileName + ".txt");
    }

    @Override
    public void upload() {
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();
        presenterDog.upload(fileName);
    }

    @Override
    public void addChild() {
        System.out.print("Введите имя родителя ребенка: ");
        String parentName = scanner.nextLine();
        System.out.print("Введите пол ребенка: ");
        String gender = scanner.nextLine();
        System.out.print("Введите имя ребенка: ");
        String childName = scanner.nextLine();
        presenterDog.addChild(parentName, gender, childName);
    }

    @Override
    public void addMember() {
        System.out.print("Введите пол: ");
        String gender = scanner.nextLine();
        System.out.print("Введите кличку: ");
        String firstName = scanner.nextLine();
        presenterDog.addMember(gender, firstName);
    }

    @Override
    public void setPresenter(PresenterDog presenterDog) {
        this.presenterDog = presenterDog;
    }
}

