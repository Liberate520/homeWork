package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public abstract class Command {
    ConsoleUI consoleUI;
    public String description;

    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public abstract void execute();
}
