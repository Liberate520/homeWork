package ui.commands;

import ui.ConsoleUI;

public class SortByFirstName extends Command {
    public SortByFirstName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "По первому значению в имени";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().sortByFirstName();
    }
}
