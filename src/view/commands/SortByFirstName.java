package view.commands;

import view.ConsoleUI;

public class SortByFirstName implements Command {
    private ConsoleUI consoleUI;

    public SortByFirstName(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Отсортировать фамильное дерево по именам";
    }

    @Override
    public void execute() {
        consoleUI.sortByFirstName();
    }
}
