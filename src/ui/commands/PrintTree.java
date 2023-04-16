package ui.commands;

import ui.ConsoleUI;

public class PrintTree extends Command {
    public PrintTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести на экран информацию по текущему генеалогическому древу";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().printTree();
    }
}
