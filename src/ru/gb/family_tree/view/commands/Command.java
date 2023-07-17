package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleView;

import java.io.IOException;

public abstract class Command {
    ConsoleView consoleView;
    String description;

    public Command(ConsoleView consoleView, String description) {
        this.consoleView = consoleView;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public abstract void execute();
}
