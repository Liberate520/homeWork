package view.commands;

import view.ConsoleUI;

public class AddHuman extends Command{

    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI, "Добавить родственника");
    }

    @Override
    public void execute() {
        consoleUI.addHuman();
    }
}
