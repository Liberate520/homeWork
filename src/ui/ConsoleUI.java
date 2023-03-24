package ui;


import presenter.Presenter;
import ui.menu.Menu;
import ui.menu.SimpleMenu;

import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Validator validator;
    private Menu menu;
    private Scanner scanner;
    boolean flag;

    public ConsoleUI() {
        this.menu = new SimpleMenu(this);
        validator = new Validator();
        scanner = ScannerSingleton.getScanner();
        flag = true;
    }

    @Override
    public void infoOutput() {
        presenter.infoOutput();
    }

    @Override
    public void addRecord() {
        presenter.addRecord();
    }

    @Override
    public void removeRecord() {
        presenter.removeRecord();
    }

    @Override
    public void changeRecord() {
        presenter.changeRecord();
    }

    @Override
    public void exit() {
        flag = false;
        System.out.println("\nSave data...");
    }

    @Override
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        System.out.println("Welcome Home User!");
        System.out.println("(Type \"exit\" anywhere for emergency exit without saving data )");
        System.out.println("(To save data choose exit menu.)");
        while (flag) {
            menu.showMenu();
            System.out.print("Your Choice: ");
            menu.execute(validator.valMenuChoice(scanner.nextLine(), menu.getMenuListSize()));
        }
    }

    @Override
    public int scan() {
        System.out.print("Your choice: ");
        String choice = scanner.nextLine();
        return validator.valInt(choice);
    }

    @Override
    public void succeeded(boolean isWork) {
        if (!isWork) {
            System.out.println("Can`t find record with your ID");
        } else System.out.println("Success!");
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public String scanRecord() {
        System.out.print("Enter new Record: ");
        return validator.emergency_exit(scanner.nextLine());
    }
}
