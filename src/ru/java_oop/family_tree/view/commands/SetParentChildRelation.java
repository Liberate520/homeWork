package ru.java_oop.family_tree.view.commands;

import ru.java_oop.family_tree.view.ConsoleUI;

public class SetParentChildRelation extends Command {
    public SetParentChildRelation(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Set parent/child relation";
    }

    @Override
    public void execute() {
        consoleUI.setParentChildRelation();
    }
}
