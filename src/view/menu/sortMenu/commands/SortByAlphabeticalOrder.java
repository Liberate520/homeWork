package view.menu.sortMenu.commands;

import view.ConsoleUI;
import view.menu.mainMenu.commands.Command;

public class SortByAlphabeticalOrder implements Command {

    ConsoleUI consoleUI;

    public SortByAlphabeticalOrder(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }


    @Override
    public String getDescription() {
        return "Отсортировать по именам в алфавитном порядке.";
    }

    @Override
    public void execute() {
        consoleUI.sortByAlphabeticalOrder();

    }
}
