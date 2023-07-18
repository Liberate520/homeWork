package view.console.commands;

import view.console.ConsoleUI;

public class LoadTree extends Command {
    public LoadTree(ConsoleUI consoleUI) {
        super("загрузить сохранённое древо", consoleUI);
    }

    public void execute() {
        consoleUI.loadTree();
    }
}