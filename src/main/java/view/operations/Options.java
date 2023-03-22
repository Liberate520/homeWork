package view.operations;

import view.ConsoleUI;

public abstract class Options {
    private ConsoleUI consoleUI;

    public Options(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public ConsoleUI getConsole() {
        return consoleUI;
    }

    public abstract String optionName();

    public abstract void execute();

}
