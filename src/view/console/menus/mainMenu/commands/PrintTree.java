package view.console.menus.mainMenu.commands;

import view.console.ConsoleUI;

public class PrintTree extends Command {
    public PrintTree(ConsoleUI consoleUI) {
        super("отобразить текущее древо", consoleUI);
    }

    public void execute() {
        consoleUI.printTree();
    }
}