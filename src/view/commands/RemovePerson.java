package view.commands;

import view.ConsoleUI;

public class RemovePerson extends Command {

    public RemovePerson(ConsoleUI consoleUI) {
        super("Remove Person", consoleUI);

    }

    @Override
    public void execute() {
        super.getConsoleUI().removePerson();
    }
}