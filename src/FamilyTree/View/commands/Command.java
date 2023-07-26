package FamilyTree.View.commands;

import FamilyTree.View.ConsoleUI;

import java.io.IOException;

public abstract class Command {
    public String description;
    public ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute() throws IOException, ClassNotFoundException;


}
