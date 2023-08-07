package View.commands;

import View.ConsoleUI;

public class DelHuman extends Command {

    public DelHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Удалить человека";
    }

    public void execute() {
        consoleUI.delHuman();
    }
}