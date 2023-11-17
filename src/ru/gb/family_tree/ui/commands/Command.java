package ru.gb.family_tree.ui.commands;

import ru.gb.family_tree.ui.ConsoleUI;

public abstract class Command {

    String description;
    ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}
