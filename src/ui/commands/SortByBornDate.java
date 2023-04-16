package ui.commands;

import ui.ConsoleUI;

public class SortByBornDate extends Command {
    public SortByBornDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "По дате рождения";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().sortByBornDate();
    }
}
