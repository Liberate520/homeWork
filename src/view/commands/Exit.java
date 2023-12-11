package view.commands;

import view.ConsoleUI;

public class Exit extends Command {

    public Exit(ConsoleUI consoleUI) {
        super("Выход", consoleUI);
    }
    @Override
    public void execute() {
        getConsoleUI().setWork(false);
    }
}
