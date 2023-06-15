package view.consoleUI.menu.mainMenu.commands;

import view.consoleUI.ConsoleUI;

public class SortedTree implements Command{
    ConsoleUI consoleUI;

    public SortedTree(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Отсортировать древо";
    }

    @Override
    public void execute() {
        consoleUI.sortTree();
    }
}
