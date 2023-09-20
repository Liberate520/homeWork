package view.commands;

import view.ConsoleUI;

public class SortByName extends Command {

    public SortByName(ConsoleUI consoleUI) {
        super("Sort persons by name", consoleUI);

    }

    @Override
    public void execute() {
        super.getConsoleUI().sortByName();
    }
}
