package view.commands.allCommands;

import view.ConsoleUI;

public class SortByAge extends Command {
    public SortByAge(ConsoleUI consoleUI) {
        super("Sort by age", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().sortByAge();
    }
}
