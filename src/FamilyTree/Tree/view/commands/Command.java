package FamilyTree.Tree.view.commands;

import FamilyTree.Tree.view.ConsoleUI;

import java.io.Console;

public abstract class Command {
    private String description;
    private ConsoleUI consoleUI;


    protected Command(String description, ConsoleUI consoleUI) {
        this.description = description;
        this.consoleUI = consoleUI;
    }

    public Command(Console console) {
    }

    ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract String description();

    public abstract void execute();
}
