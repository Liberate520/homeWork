package view.console.commands;

import view.console.ConsoleUI;

public class SaveTree extends Command {
    public SaveTree(ConsoleUI consoleUI) {
        super("сохранить текущее древо", consoleUI);
    }

    public void execute() {
        consoleUI.saveTree();
    }
}