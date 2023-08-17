package view.commands;

import view.ConsoleUI;

public class AddPerson extends Command{
    public AddPerson(ConsoleUI consoleUI) {
        super("Добавить человека.", consoleUI);
    }

    @Override
    public void execute() {
        consoleUI.addPerson();
    }
}
