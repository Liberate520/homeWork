package view.commands;

import view.ConsoleUI;

public class ShowNotInTree extends Command{

    public ShowNotInTree(ConsoleUI consoleUI) {
        super("Показать людей вне дерева", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().showNotInTree();
    }
}
