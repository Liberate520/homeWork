package view.commands;

import view.ConsoleUI;

public class ShowInTree extends Command {

    public ShowInTree(ConsoleUI consoleUI) {
        super("Показать людей, добавленных в дерево", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().showTree();
    }
}
