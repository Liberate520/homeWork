package genealogy_tree.ui.commands;

import genealogy_tree.ui.ConsoleUI;

public abstract class Command {
    private String descripion;
     private ConsoleUI consoleUI;

    public Command(String descripion, ConsoleUI consoleUI) {
        this.descripion = descripion;
        this.consoleUI = consoleUI;
    }

    ConsoleUI getConsoleUI(){
        return consoleUI;
    }
    public String getDescripion(){
        return descripion;
    }
    public abstract void execut();
}
