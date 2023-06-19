package view.commands;

import view.ConsoleUI;

public class SortByLastName implements Command {
    private ConsoleUI consoleUI;

    public SortByLastName(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Отсортировать фамильное дерево по фамилиям";
    }

    @Override
    public void execute() {
        consoleUI.sortByLastName();
    }
}
