package mvp.ui;

import java.util.Scanner;

import mvp.presenter.Presenter;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean flagWork;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        flagWork = true;
        mainMenu = new MainMenu(this);
        presenter = new Presenter();
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (flagWork) {
            System.out.println("\n\n>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("Семейное дерево\n");
            System.out.println(mainMenu.printMenu());
            // ПРОВЕРКА НА КОРРЕКТНОСТЬ ВВОДА:
            int choice = inputNumMenu();

            if (choice == -1) {
                System.out.println("Ошибка ввода");
                continue;
            }

            mainMenu.execute(choice);
        }
    }

    public void addNote() {
        System.out.println("Дата совершения операции");
        String timeWrite = scanner.nextLine();

        System.out.println("Записать: ");
        String textWrite = scanner.nextLine();
        presenter.addNote(timeWrite, textWrite);
    }

    public void getNote() {
        System.out.println("Укажите событие");
        String text = scanner.nextLine();
        presenter.getNote(text);
    }

    public void getAllNote() {
        presenter.getAllNote();
    }

    public void end() {
        System.out.println("Хорошего дня;)");
        flagWork = false;
    }

    private int inputNumMenu() {
        String line = scanner.nextLine();
        if (!checkLine(line)) {
            System.out.println("Такого действия нет в меню");
            return -1;
        }
        return Integer.parseInt(line);
    }

    private boolean checkLine(String line) {
        if (!line.matches("[0-9]+")) {
            return false;
        }

        int choice = Integer.parseInt(line);

        return choice > 0 && choice <= mainMenu.size();
    }

}
