package FamilyTree.Tree.view.commands;

import FamilyTree.Tree.view.ConsoleUI;

import java.io.Console;

public abstract class Command {
    private String description;
    ConsoleUI consoleUI;


    public Command(String description, ConsoleUI consoleUI) {
        this.description = description;
        this.consoleUI = consoleUI;
    }

    public ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}
