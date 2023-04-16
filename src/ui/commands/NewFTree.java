package ui.commands;

import ui.ConsoleUI;

public class NewFTree extends Command {
    public NewFTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Создать генеалогическое древо";
    }

    @Override
    public boolean execute() {
        getConsoleUI().newFTree();
        return true;
    }
}
