package ru.gb.family_tree.view.command;

import view.ConsoleUI;

public class ShowHumanTree extends Command{

    public ShowHumanTree(ConsoleUI consoleUI) {
        super("Show human tree", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().showHumanTree();
    }
}