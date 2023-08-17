package homeWork.family_tree.view.commands;

import homeWork.family_tree.view.ConsoleUI;

public class SortByName extends Command {

    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public String getDescription() {
        return "Отсортировать по имени";
    }

    public void execute() {
        getConsoleUI().sortByName();

    }
}
