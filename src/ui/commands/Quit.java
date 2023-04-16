package ui.commands;

import ui.ConsoleUI;

public class Quit extends Command{
    public Quit(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выход из приложения";
    }

    @Override
    public boolean execute() {
        getConsoleUI().quit();
        return false;
    }
}
