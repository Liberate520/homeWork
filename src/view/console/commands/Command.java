package view.console.commands;

import view.console.ConsoleUI;

public abstract class Command {
    private String description;
    protected ConsoleUI consoleUI;

    protected Command(String description, ConsoleUI consoleUI) {
        this.description = description;
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}