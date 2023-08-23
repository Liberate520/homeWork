package View.commands;

import View.ConsoleUI;

public class FindById extends Command {
    public FindById(ConsoleUI consoleUI) {
        super("Найти человека по id", consoleUI);
    }
    public void execute() {
        getConsoleUI().findById();
    }
}
