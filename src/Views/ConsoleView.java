package Views;

import java.util.Scanner;

import Presenters.NotesPresenter;

public class ConsoleView implements View, Executable {

    // #region fields
    private boolean isWork;
    private Menu menu;
    private Scanner scanner;
    private NotesPresenter presenter;
    private String[] parameters;
    private Integer choice;
    private final String WRONG = "wrong input, read help";
    private final String SUCCESS = "operation is done";
    private final String FAIL = "operation failed";

    // #endregion
    public ConsoleView() {
        isWork = true;
        menu = new Menu(this);
        scanner = new Scanner(System.in);
        presenter = new NotesPresenter();
    }

    // #region implements view
    @Override
    public void print(String text) {
        System.out.print(text);
    }

    @Override
    public void start() {
        showMenu();
        showInputField();
        do {
            Dialog();
        } while (isWork);
    }
    // #endregion

    // #region dialogs
    /** печать заголовка */
    private void showTitle() {
        print("\u2591\u2591\u2592\u2593\u2588\u001B[47mPOWERFUL NOTE APPLICATION\u001B[0m\u2588\u2593\u2592\u2591\u2591\n");
    }

    /** показ меню */
    private void showMenu() {
        clearScreen();
        showTitle();
        print(this.menu.toString());
        print("\n-----------------------------------------------------\n");
    }

    /** основная логика диалога с пользователем */
    private void Dialog() {
        do {
            showInputField();
        } while (!getInput(scanner.nextLine()));
        showMenu();
        menu.execute(this.choice);
    }

    /** получение ввода от пользователя */
    private boolean getInput(String line) {
        parameters = line.split("/");
        if (isDigit(parameters[0])) {
            choice = Integer.parseInt(parameters[0]) - 1;
            return true;
        }
        return false;
    }

    /** проверка является ли строка числом */
    private boolean isDigit(String data) {
        return data.matches("[0-9]+");
    }

    /** печать поля ввода */
    private void showInputField() {
        print("\n-----------------------------------------------------\n");
        print("> ");
    }

    /** очистка консоли */
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void printResult(boolean result) {
        if (result) {
            print(String.format("\u001B[32m%s\u001B[0m", SUCCESS, parameters));
        } else {
            print(String.format("\u001B[31m%s\u001B[0m", FAIL, parameters));
        }
    }

    // #endregion

    // #region implements executable
    @Override
    public void show() {
        if (parameters.length == 1)
            print(presenter.show(null, null));
        else if (parameters.length == 2)
            print(presenter.show(parameters[1], null));
        else if (parameters.length >= 3)
            print(presenter.show(parameters[1], parameters[2]));
        else {
            print(WRONG);
        }
    }

    @Override
    public void read() {
        if (parameters.length < 2) {
            print(WRONG);
            return;
        }
        if (isDigit(parameters[1])) {
            print(presenter.getNote(Integer.parseInt(parameters[1])));
        } else {
            print(presenter.getNote(parameters[1]));
        }

    }

    @Override
    public void create() {
        if (parameters.length < 4) {
            print(WRONG);
            return;
        }
        printResult(presenter.addNote(parameters[1], parameters[2], parameters[3]));
    }

    @Override
    public void remove() {
        if (parameters.length < 2) {
            print(WRONG);
            return;
        }
        printResult(isDigit(parameters[1]) && presenter.remove(Integer.parseInt(parameters[1])));

    }

    @Override
    public void update() {
        if (parameters.length < 5) {
            print(WRONG);
            return;
        }
        printResult(isDigit(parameters[1])
                && presenter.updateNote(Integer.parseInt(parameters[1]), parameters[2], parameters[3], parameters[4]));
    }

    @Override
    public void clear() {
        printResult(presenter.clear());
    }

    @Override
    public void save() {
        printResult(presenter.save());
    }

    @Override
    public void help() {
        print(menu.getHelp());
    }

    @Override
    public void quit() {
        print("thank's for using this application!\n");
        isWork = false;
    }
    // #endregion
}