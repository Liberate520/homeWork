package view.menu.sortMenu.commands;

import model.familyTrees.FamilyTree;
import view.ConsoleUI;
import view.menu.mainMenu.commands.Command;

public class SortByNameLength implements Command {
    ConsoleUI consoleUI;

    public SortByNameLength(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Отсортировать по длине имени";
    }

    @Override
    public void execute() {
        consoleUI.sortByNameLength();

    }
}
