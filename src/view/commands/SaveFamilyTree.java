package view.commands;

import view.ConsoleUI;

public class SaveFamilyTree extends Command {
    public SaveFamilyTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Save family tree.";
    }

    public void execute(){
        consoleUI.saveFamilyTree();
    }
}