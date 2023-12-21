package ru.gb.family_tree.view.command;

import view.ConsoleUI;

public class ShowInTree extends Command {

    public ShowInTree(ConsoleUI consoleUI) {
        super("Show added to tree people", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().showTree();
    }
}
