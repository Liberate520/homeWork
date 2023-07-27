package ru.java_oop.family_tree.view.commands;

import ru.java_oop.family_tree.view.ConsoleUI;

public class LoadFamilyTreeFromFile extends Command {

    public LoadFamilyTreeFromFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Load Family Tree from file";
    }

    @Override
    public void execute() {
        consoleUI.loadFamilyTreeFromFile();
    }
}
