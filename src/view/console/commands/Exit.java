package view.console.commands;

import view.console.ConsoleUI;

public class Exit extends Command {
    public Exit(ConsoleUI consoleUI) {
        super("завершение работы", consoleUI);
    }

    public void execute() {
        consoleUI.exit();
    }
}