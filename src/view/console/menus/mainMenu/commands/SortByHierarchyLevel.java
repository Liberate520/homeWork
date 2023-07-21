package view.console.menus.mainMenu.commands;

import view.console.ConsoleUI;

public class SortByHierarchyLevel extends Command {
    public SortByHierarchyLevel(ConsoleUI consoleUI) {
        super("отсортировать текущее древо по иерархии", consoleUI);
    }

    public void execute() {
        consoleUI.sortByHierarchyLevel();
    }
}