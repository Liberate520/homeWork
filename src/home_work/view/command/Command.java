package home_work.view.command;

import home_work.view.ConsoleUI;

/**
 * Command
 */
public abstract class Command {
    String description;
    ConsoleUI consoleUI;

    public Command(String description, ConsoleUI consoleUI) {
        this.description = description;
        this.consoleUI = consoleUI;
    }

    ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}