package view.console.menus.mainMenu.commands;

import view.console.ConsoleUI;

public class SetParentToCurrItemById extends Command {
    public SetParentToCurrItemById(ConsoleUI consoleUI) {
        super("установить текущему человеку родителя", consoleUI);
    }

    public void execute() {
        consoleUI.setParentToCurrItemById();
    }
}