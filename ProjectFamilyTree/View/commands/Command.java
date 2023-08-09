package homeWork.ProjectFamilyTree.View.commands;

import homeWork.ProjectFamilyTree.View.ConsoleUI;

import java.io.IOException;

public abstract class Command {
    private String description;
    ConsoleUI consoleUI;

    public Command(String description, ConsoleUI consoleUI) {
        this.description = description;
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }
    public abstract void execute() throws IOException, ClassNotFoundException;
}
