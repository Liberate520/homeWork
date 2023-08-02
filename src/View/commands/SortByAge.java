package View.commands;

import View.ConsoleUI;

public class SortByAge extends Command {
    public SortByAge(ConsoleUI consoleUI) {
        super("Отсортируйте по возрасту", consoleUI);
    }

    public void execute() {
        getConsoleUI().sortByAge();
    }
}
