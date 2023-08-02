package View.commands;

import View.ConsoleUI;

public class Save extends Command {
    public Save(ConsoleUI consoleUI) {
        super("Сохраните изменения в файл", consoleUI);
    }
    public void execute() {
        getConsoleUI().save();
    }
}