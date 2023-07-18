package view.console.commands;

import view.console.ConsoleUI;

public class NewTree extends Command {
    public NewTree(ConsoleUI consoleUI) {
        super("создать новое древо", consoleUI);
    }

    public void execute() {
        consoleUI.newTree();
    }
}