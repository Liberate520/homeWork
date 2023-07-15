package ru.java_oop.family_tree.view.commands;

import ru.java_oop.family_tree.view.ConsoleUI;

public class GetFamilyTreeInfo extends Command {

    public GetFamilyTreeInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Get family tree info";
    }

    @Override
    public void execute() {
        consoleUI.getFamilyTreeInfo();
    }
}
