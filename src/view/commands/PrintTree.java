package view.commands;

import view.ConsoleUI;

public class PrintTree extends Command{
    public PrintTree(ConsoleUI consoleUI) {
        super("Вывести список.", consoleUI);
    }

    @Override
    public void execute() {
        consoleUI.printTree();
    }
}
