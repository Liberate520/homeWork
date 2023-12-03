package view.Commands;

import view.ConsoleUI;

public abstract class Commands {
    String description;
    ConsoleUI consoleUI;

    public Commands(ConsoleUI consoleUI){
        this.consoleUI = consoleUI;
    }

    public String getDescription(){
        return this.description;
    }
    public abstract void execute();
}
