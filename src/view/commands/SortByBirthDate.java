package view.commands;

import view.ConsoleUI;

public class SortByBirthDate extends Command {

    public SortByBirthDate(ConsoleUI consoleUI) {
        super("Sort persons by birth date", consoleUI);

    }

    @Override
    public void execute() {
        super.getConsoleUI().sortByBirthDate();
    }
}

