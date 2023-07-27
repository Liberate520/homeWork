package ru.java_oop.family_tree.view.commands;

import ru.java_oop.family_tree.view.ConsoleUI;

public class SortByName extends Command {
    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Sort family tree by name";
    }

    @Override
    public void execute() {
        consoleUI.sortByName();
    }
}
