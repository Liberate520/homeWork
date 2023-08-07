package View.commands;

import View.*;

public class AddHuman extends Command {

    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить нового человека";
    }

    public void execute() {
        consoleUI.addHuman();
    }
}