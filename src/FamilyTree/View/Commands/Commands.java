package family_tree.FamilyTree.View.Commands;

import family_tree.FamilyTree.View.ConsoleUI;

import java.io.IOException;


public abstract class Commands {
    private String description;
    private ConsoleUI consoleUI;

    public Commands(String description, ConsoleUI consoleUI) {
        this.description = description;
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }
    ConsoleUI getConsoleUI(){
        return this.consoleUI;
    }

    public abstract void execute() throws IOException;
}
