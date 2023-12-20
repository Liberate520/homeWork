package ru.gb.family_tree.view.commands;

public abstract class Command {
    private String description;
    private ConsoleUI consoleUI;

    public Command(String description, ConsoleUI consoleUI) {
        this.description = description;
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();

    ConsoleUI getConsoleUI() {
        return consoleUI;
    }

}
