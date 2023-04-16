package ui.commands;

import ui.ConsoleUI;

public class SortByGender extends Command {
    public SortByGender(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "По половому признаку";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().sortByGender();
    }
}
