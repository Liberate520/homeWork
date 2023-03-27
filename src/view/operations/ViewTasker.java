package view.operations;

import view.ConsoleUI;

public abstract class ViewTasker {
    // ПОЛЕ КЛАССА
    private final ConsoleUI consoleUI;

    // КОНСТРУКТОР
    public ViewTasker(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    // МЕТОДЫ
    public ConsoleUI getConsole() {
        return consoleUI;
    }

    public abstract String optionName();

    public abstract void execute();

}