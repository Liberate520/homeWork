package View.commands;

import View.ConsoleUI;

public class SetDeathDate  extends Command {
    public SetDeathDate(ConsoleUI consoleUI) {
        super("Добавьте дату смерти человека", consoleUI);
    }

    public void execute() {
        getConsoleUI().setDate();
    }
}