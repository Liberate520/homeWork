package homeWork.family_tree.view.commands;

import homeWork.family_tree.view.ConsoleUI;

public class SortByBirthDate extends Command {

    public SortByBirthDate(ConsoleUI consoleUI) {
        super("Отсортировать по возрасту", consoleUI);
    }

    public void execute() {
        getConsoleUI().sortByBirthDate();

    }
}
