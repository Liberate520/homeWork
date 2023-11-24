package view.commands;

import view.ConsoleUI;

public class LoadFamilyTree extends Command {
    public LoadFamilyTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Load family tree.";
    }

    public void execute(){
        consoleUI.loadFamilyTree();
    }
}