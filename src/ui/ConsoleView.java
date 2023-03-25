package ui;

import java.util.Scanner;

import mvp.Presenter;
import mvp.View;

public class ConsoleView implements View {
    private Presenter presenter;
    private Scanner scanner;
    private static final String WAITING_COMMAND = "Введите номер команды:\n\t1. Показать записи\n\t2. Ввести новую запись\n\t3. Выход";
    private static final String WAITING_NOTE = "Введите запись:";
    private boolean keepRunning;

    public ConsoleView() {
        scanner = new Scanner(System.in);
        keepRunning = true;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void start() {
        while (keepRunning) {
            String mainMenuItem = this.mainMenuItem();
            if (mainMenuItem.equals("1")) {
                this.print(presenter.allNotes());
            } else if (mainMenuItem.equals("2")) {
                presenter.writeNote(this.note());
            } else if (mainMenuItem.equals("3")) {
                keepRunning = false;
                print("Работа завершена");
            }
        }
    }

    public String scan() {
        return scanner.nextLine();
    }

    public void print(String outputString) {
        System.out.println(outputString);
    }

    @Override
    public void showMainMenu() {
        print(WAITING_COMMAND);
    }

    @Override
    public void showNoteInputWelcome() {
        print(WAITING_NOTE);
    }

    @Override
    public String mainMenuItem() {
        showMainMenu();
        return scan();
    }

    @Override
    public String note() {
        showNoteInputWelcome();
        return scan();
    }
}
