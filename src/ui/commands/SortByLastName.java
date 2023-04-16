package ui.commands;

import ui.ConsoleUI;

public class SortByLastName extends Command {
    public SortByLastName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "По второму значению в имени";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().sortByLastName();
    }
}
