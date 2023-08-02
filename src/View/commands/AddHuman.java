package View.commands;

import View.ConsoleUI;

public class AddHuman extends Command {
    public AddHuman(ConsoleUI consoleUI) {
        super("Добавьте человека", consoleUI);
    }
    public void execute() {
        getConsoleUI().addHuman();
    }
}
