package vieww.comands;

import vieww.ConsoleUI;

public class AddHuman implements Command {
    private ConsoleUI console;

    public AddHuman(ConsoleUI console) {
        this.console = console;
    }

    public String getDescription(){
        return "Add human";
    }

    public void execute(){
        console.addHuman();
    }
}