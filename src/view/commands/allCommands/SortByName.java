package view.commands.allCommands;

import view.ConsoleUI;
import view.commands.allCommands.Command;

public class SortByName extends Command {
    public SortByName(ConsoleUI consoleUI) {
        super("Sort by name", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().sortByName();
    }
}
