package ru.java_oop.family_tree.view.commands;

import ru.java_oop.family_tree.view.ConsoleUI;

public class SortByAge extends Command {
    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Sort family tree by age";
    }

    @Override
    public void execute() {
        consoleUI.sortByAge();
    }
}
