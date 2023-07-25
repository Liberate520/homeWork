package view.console.menus.mainMenu.commands;

import view.console.ConsoleUI;

public class AddChildToCurrItemById extends Command {
    public AddChildToCurrItemById(ConsoleUI consoleUI) {
        super("добавить текущему человеку ребёнка", consoleUI);
    }

    public void execute() {
        consoleUI.addChildToCurrItemById();
    }
}