package ui;

import java.util.Scanner;

import mvp.View;

public class ConsoleView implements View {

    private Scanner scanner;
    private static final String WAITING_COMMAND = "Введите номер команды:\n\t1. Показать записи\n\t2. Ввести новую запись\n\t3. Выход";
    private static final String WAITING_NOTE = "Введите запись:";

    public ConsoleView() {
        scanner = new Scanner(System.in);
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
