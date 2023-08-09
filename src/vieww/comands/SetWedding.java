package vieww.comands;

import vieww.ConsoleUI;

public class SetWedding implements Command {
    private ConsoleUI console;

    public SetWedding(ConsoleUI console) {
        this.console = console;
    }

    public String getDescription(){
        return "Set wedding";
    }

    public void execute(){
        console.setWedding();
    }
}