package view.consoleUI.menu.allRecordsMenu.commands;

import view.consoleUI.ConsoleUI;
import view.consoleUI.menu.mainMenu.commands.Command;

public class SortedTree implements Command {
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
        consoleUI.runSortingMenu();
    }
}
