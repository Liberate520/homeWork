package view.commands;

import view.ConsoleUI;

public class ShowHumanTree extends Command{

    public ShowHumanTree(ConsoleUI consoleUI) {
        super("Отобразить иерархию дерева", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().showHumanTree();
    }
}
