package FamilyTree.view.commands;

import FamilyTree.view.ConsoleUI;

public class SortByName implements Command {
    ConsoleUI consoleUI;

    public SortByName(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getCommandDescription() {
        return "Отсортировать по имени";
    }

    @Override
    public void execute() {
        consoleUI.sortByName();
    }
}
