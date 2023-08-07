package view.commands;

import view.ConsoleUI;

public abstract class Command {
    protected String description;
    protected ConsoleUI consoleUI;

    public Command(String description, ConsoleUI consoleUI) {
        this.description = description;
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}
