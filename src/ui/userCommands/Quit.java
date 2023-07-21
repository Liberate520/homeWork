package ui.userCommands;

import ui.ConsoleUI;

public class Quit extends Command{
    public Quit(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выход из программы";
    }

    @Override
    public boolean execute() {
        getConsoleUI().quit();
        return false;
    }
}
