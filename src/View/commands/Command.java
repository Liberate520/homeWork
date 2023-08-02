package View.commands;

import View.ConsoleUI;

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
    ConsoleUI getConsoleUI(){
        return consoleUI;
    }

    public void execute() {
    }
}
