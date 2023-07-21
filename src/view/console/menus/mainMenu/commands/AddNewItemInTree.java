package view.console.menus.mainMenu.commands;

import view.console.ConsoleUI;

public class AddNewItemInTree extends Command {
    public AddNewItemInTree(ConsoleUI consoleUI) {
        super("добавить нового человека в древо", consoleUI);
    }

    public void execute() {
        consoleUI.addNewItemInTree();
    }
}