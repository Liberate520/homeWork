package view.commands.allCommands;

import view.ConsoleUI;

public class SortByGender extends Command {
    public SortByGender(ConsoleUI consoleUI) {
        super("Sort by name", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().sortByGender();
    }
}
