package ui.userCommands;

import ui.ConsoleUI;

public class PrintTree extends Command {
    public PrintTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Распечатать информацию о дереве";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().printTree();
    }
}
