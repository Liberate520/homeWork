package view.commands;

import view.ConsoleUI;

public class FindPerson extends Command{
    public FindPerson(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Найти человека.";
    }

    @Override
    public void execute() {
        consoleUI.findPerson();
    }
}
