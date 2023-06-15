package view.menu.mainMenu.commands;

import view.ConsoleUI;

public class SortMenu implements Command{
    ConsoleUI consoleUI;

    public SortMenu(ConsoleUI consoleUI) {
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
