package view.menu.sortMenu.commands;

import model.service.HumanService;
import view.ConsoleUI;
import view.menu.mainMenu.commands.Command;

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
