package view.commands;

import view.ConsoleUI;

public abstract class Command implements ICommand {
    private String description;
    public ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public String getDescription(){
        return description;
    }

    public ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    public abstract void execute();
}
