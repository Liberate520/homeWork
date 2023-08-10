package homeWork.family_tree.view.commands;

import homeWork.family_tree.view.ConsoleUI;

public class SortByName extends Command {

    public SortByName(ConsoleUI consoleUI) {
        super("Отсортировать по имени", consoleUI);
    }

    public void execute() {
        getConsoleUI().sortByName();

    }
}
