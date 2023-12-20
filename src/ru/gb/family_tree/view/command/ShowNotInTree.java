package ru.gb.family_tree.view.command;

import view.ConsoleUI;

public class ShowNotInTree extends Command{

    public ShowNotInTree(ConsoleUI consoleUI) {
        super("Show all out of tree people", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().showNotInTree();
    }
}