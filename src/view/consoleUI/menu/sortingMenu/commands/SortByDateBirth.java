package view.consoleUI.menu.sortingMenu.commands;

import view.consoleUI.ConsoleUI;
import view.consoleUI.menu.mainMenu.commands.Command;

public class SortByDateBirth implements Command {
    ConsoleUI consoleUI;

    public SortByDateBirth(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Отсортировать по году рождения";
    }

    @Override
    public void execute() {
        consoleUI.sortByDateBirth();

    }
}
