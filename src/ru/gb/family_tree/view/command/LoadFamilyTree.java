package ru.gb.family_tree.view.command;

import view.ConsoleUI;

public class LoadFamilyTree extends Command{
    public LoadFamilyTree(ConsoleUI consoleUI) {
        super("Load family tree", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().loadFamilyTree();
    }
}
