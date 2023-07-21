package view.console.menus.mainMenu.commands;

import view.console.ConsoleUI;

public class SetCurrentItemById extends Command {
    public SetCurrentItemById(ConsoleUI consoleUI) {
        super("выбрать текущего человека по id", consoleUI);
    }

    public void execute() {
        consoleUI.setCurrentItemById();
    }
}