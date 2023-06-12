package view.commands;

import view.ConsoleUI;

public class SortByChildrenCount implements Command {
    private ConsoleUI consoleUI;

    public SortByChildrenCount(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Отсортировать фамильное дерево по количеству детей";
    }

    @Override
    public void execute() {
        consoleUI.sortByChildrenCount();
    }
}
