package FamilyTree.view.commands;

import FamilyTree.view.ConsoleUI;

public class SortByAge implements Command{
    private ConsoleUI consoleUI;

    public SortByAge(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getCommandDescription() {
        return "Отсортировать по дате рождения";
    }

    @Override
    public void execute() {
        consoleUI.sortByAge();
    }
}
