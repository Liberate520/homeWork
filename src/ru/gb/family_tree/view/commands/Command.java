package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.Console;

public class Command {
    private String description;
    private Console console;

    public Command(String description, Console console) {
        this.description = description;
        this.console = console;
    }

    public String getDescription() {
        return description;
    }

    public Console getConsole() {
        return console;
    }

    public abstract void execute();
}
