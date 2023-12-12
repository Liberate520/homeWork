package view.commands;

import view.ConsoleUI;

public abstract class Command {
    String description;
    ConsoleUI consoleUI;

    public String getDescription() { return description;}
    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public abstract void execute();
}
