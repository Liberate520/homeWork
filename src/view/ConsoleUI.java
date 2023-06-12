package view;

import java.io.IOException;
import java.util.Scanner;
import presenter.Presenter;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private MainMenu mainMenu;
    boolean repeatFlag;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        mainMenu = new MainMenu(this);
        repeatFlag = true;
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        System.out.println("Выберите действие:");
        while (repeatFlag) {
            System.out.println(mainMenu.printMenu());
            int choice = inputNumMenu();
            if (choice == -1) {
                System.out.println("Ошибка ввода!");
                continue;
            }
            mainMenu.execute(choice);
        }
    }

    @Override
    public void finish() {
        System.out.println("Работа завершена.");
        System.exit(0);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
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
        return choice > 0 && choice <= 5;
    }

    public void saveData() throws IOException {
        presenter.saveData();
    }

    public void loadData() throws IOException, ClassNotFoundException {
        presenter.loadData();
    }

    public void printSortByName() {
        presenter.printSortByName();
    }

    public void printSortByDOB() {
        presenter.printSortByDOB();
    }
}
