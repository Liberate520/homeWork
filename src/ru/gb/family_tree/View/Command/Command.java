package ru.gb.family_tree.View.Command;

import ru.gb.family_tree.View.ConsoleUI;

public abstract class Command {
    private String description;
    private ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI,String description) {
        this.description = description;
        this.consoleUI = consoleUI;
    }
    public abstract void execute();

    public String getDescription() {
        return description;
    }

     ConsoleUI getConsoleUI() {
        return consoleUI;
    }
}
