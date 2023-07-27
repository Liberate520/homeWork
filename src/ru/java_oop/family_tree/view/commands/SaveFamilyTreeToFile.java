package ru.java_oop.family_tree.view.commands;

import ru.java_oop.family_tree.view.ConsoleUI;

public class SaveFamilyTreeToFile extends Command {

    public SaveFamilyTreeToFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Save current Family Tree to file";
    }

    @Override
    public void execute() {
        consoleUI.saveFamilyTreeToFile();
    }
}
