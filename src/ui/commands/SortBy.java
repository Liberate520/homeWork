package ui.commands;

import ui.ConsoleUI;

public class SortBy extends Command {
    public SortBy(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сортировка по ...";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().SortBy();
    }
}
