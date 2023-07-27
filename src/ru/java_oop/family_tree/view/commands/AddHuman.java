package ru.java_oop.family_tree.view.commands;

import ru.java_oop.family_tree.view.ConsoleUI;

public class AddHuman extends Command {
    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Add human to family tree";
    }

    @Override
    public void execute() {
        consoleUI.addHuman();
    }
}
