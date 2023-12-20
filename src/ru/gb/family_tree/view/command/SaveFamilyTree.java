package ru.gb.family_tree.view.command;

import view.ConsoleUI;

public class SaveFamilyTree extends Command{
    public SaveFamilyTree(ConsoleUI consoleUI) {
        super("Sava family tree", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().saveFamilyTree();
    }
}
