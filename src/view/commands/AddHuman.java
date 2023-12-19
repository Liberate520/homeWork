package view.commands;

import view.ConsoleUI;

public class AddHuman extends Command{
    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Ввести нового человека.";
    }

    @Override
    public void execute() {
        consoleUI.addHuman();
    }
}
