package vieww.comands;

import vieww.ConsoleUI;

public class RemoveHuman implements Command {
    private ConsoleUI console;

    public RemoveHuman(ConsoleUI console) {
        this.console = console;
    }

    public String getDescription(){
        return "Remove human";
    }

    public void execute(){
        console.removeHuman();
    }
}